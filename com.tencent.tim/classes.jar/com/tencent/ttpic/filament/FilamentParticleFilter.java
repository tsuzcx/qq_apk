package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.google.android.filament.Box;
import com.google.android.filament.Camera;
import com.google.android.filament.Camera.Fov;
import com.google.android.filament.Engine;
import com.google.android.filament.Entity;
import com.google.android.filament.EntityManager;
import com.google.android.filament.Fence;
import com.google.android.filament.Fence.Mode;
import com.google.android.filament.IndexBuffer;
import com.google.android.filament.IndexBuffer.Builder;
import com.google.android.filament.IndexBuffer.Builder.IndexType;
import com.google.android.filament.Material;
import com.google.android.filament.RenderableManager.Builder;
import com.google.android.filament.RenderableManager.PrimitiveType;
import com.google.android.filament.Renderer;
import com.google.android.filament.Scene;
import com.google.android.filament.SwapChain;
import com.google.android.filament.VertexBuffer;
import com.google.android.filament.VertexBuffer.AttributeType;
import com.google.android.filament.VertexBuffer.Builder;
import com.google.android.filament.VertexBuffer.VertexAttribute;
import com.google.android.filament.View;
import com.google.android.filament.Viewport;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.oscarcamera.particlesystem.ParticleSystemEx;
import com.tencent.ttpic.ar.sensor.representation.Vector3f;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.ar.ARMatrixUtil;
import com.tencent.ttpic.util.HandlerUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

public class FilamentParticleFilter
{
  public static final boolean DEBUG = true;
  private Camera camera;
  private final String dataPath;
  private LinkedBlockingDeque<Runnable> drawQueue = new LinkedBlockingDeque();
  private Engine engine;
  private float far = 2000.0F;
  private Frame filamentFrame = new Frame();
  private int height;
  private IndexBuffer indexBuffer;
  private CountDownLatch lock;
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Handler mHandler;
  private List<String> mParticleDirList;
  private ParticleSystemEx mParticleSystem = new ParticleSystemEx(AEModule.getContext());
  private SurfaceTextureFilter mPreviewFilter = new SurfaceTextureFilter();
  private int[] mPreviewTextureId = new int[2];
  private Material material;
  private float near = 100.0F;
  @Entity
  private int renderable = 0;
  private Renderer renderer;
  private int rotation;
  private Scene scene;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private SwapChain swapChain;
  private VertexBuffer vertexBuffer;
  private View view;
  private int width;
  
  public FilamentParticleFilter(List<String> paramList, String paramString)
  {
    this.dataPath = paramString;
    initParticle(paramList);
    ARMatrixUtil.startOrientationSensor();
    paramList = new HandlerThread("HTM_Particle");
    paramList.start();
    this.mHandler = new Handler(paramList.getLooper());
  }
  
  private void createMesh(List<FilamentParticleUtil.Particle> paramList)
  {
    int j = paramList.size();
    VertexForTriangle[] arrayOfVertexForTriangle = new VertexForTriangle[j];
    float[] arrayOfFloat = new float[j];
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(j * 16).order(ByteOrder.nativeOrder());
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(j * 4).order(ByteOrder.nativeOrder());
    ByteBuffer localByteBuffer3 = ByteBuffer.allocate(2 * j).order(ByteOrder.nativeOrder());
    int i = 0;
    while (i < j)
    {
      FilamentParticleUtil.Particle localParticle = (FilamentParticleUtil.Particle)paramList.get(i);
      arrayOfVertexForTriangle[i] = new VertexForTriangle(localParticle.position.x(), localParticle.position.y(), localParticle.position.z(), -65536);
      float f1 = localParticle.size.width;
      float f2 = localParticle.size.width;
      float f3 = localParticle.size.height;
      arrayOfFloat[i] = ((float)Math.sqrt(localParticle.size.height * f3 + f1 * f2) / 2.0F);
      ByteBufferUtil.put(localByteBuffer1, arrayOfVertexForTriangle[i]);
      localByteBuffer2.putFloat(arrayOfFloat[i]);
      localByteBuffer3.putShort((short)i);
      i += 1;
    }
    localByteBuffer1.flip();
    localByteBuffer2.flip();
    localByteBuffer3.flip();
    this.vertexBuffer = new VertexBuffer.Builder().vertexCount(j).bufferCount(2).attribute(VertexBuffer.VertexAttribute.POSITION, 0, VertexBuffer.AttributeType.FLOAT3, 0, 16).attribute(VertexBuffer.VertexAttribute.COLOR, 0, VertexBuffer.AttributeType.UBYTE4, 12, 16).normalized(VertexBuffer.VertexAttribute.COLOR).attribute(VertexBuffer.VertexAttribute.CUSTOM0, 1, VertexBuffer.AttributeType.FLOAT, 0, 4).build(this.engine);
    this.vertexBuffer.setBufferAt(this.engine, 0, localByteBuffer1);
    this.vertexBuffer.setBufferAt(this.engine, 1, localByteBuffer2);
    this.indexBuffer = new IndexBuffer.Builder().indexCount(j).bufferType(IndexBuffer.Builder.IndexType.USHORT).build(this.engine);
    this.indexBuffer.setBuffer(this.engine, localByteBuffer3);
  }
  
  private void createMeshForPoints()
  {
    VertexForPoint[] arrayOfVertexForPoint = new VertexForPoint[100];
    float[] arrayOfFloat = new float[100];
    short[] arrayOfShort = new short[100];
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(1200).order(ByteOrder.nativeOrder());
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(400).order(ByteOrder.nativeOrder());
    ByteBuffer localByteBuffer3 = ByteBuffer.allocate(200).order(ByteOrder.nativeOrder());
    int i = 0;
    while (i < 100)
    {
      float f = i * 0.06283186F;
      int j = (int)(i * 2.56F);
      arrayOfVertexForPoint[i] = new VertexForPoint((float)Math.cos(f), (float)Math.sin(f), j << 16 | 0xFF000000 | j | j << 8);
      arrayOfFloat[i] = (12.0F + i * 1.28F);
      arrayOfShort[i] = ((short)i);
      ByteBufferUtil.put(localByteBuffer1, arrayOfVertexForPoint[i]);
      localByteBuffer2.putFloat(arrayOfFloat[i]);
      localByteBuffer3.putShort((short)i);
      i += 1;
    }
    localByteBuffer1.flip();
    localByteBuffer2.flip();
    localByteBuffer3.flip();
    this.vertexBuffer = new VertexBuffer.Builder().vertexCount(100).bufferCount(2).attribute(VertexBuffer.VertexAttribute.POSITION, 0, VertexBuffer.AttributeType.FLOAT2, 0, 12).attribute(VertexBuffer.VertexAttribute.COLOR, 0, VertexBuffer.AttributeType.UBYTE4, 8, 12).normalized(VertexBuffer.VertexAttribute.COLOR).attribute(VertexBuffer.VertexAttribute.CUSTOM0, 1, VertexBuffer.AttributeType.FLOAT, 0, 4).build(this.engine);
    this.vertexBuffer.setBufferAt(this.engine, 0, localByteBuffer1);
    this.vertexBuffer.setBufferAt(this.engine, 1, localByteBuffer2);
    this.indexBuffer = new IndexBuffer.Builder().indexCount(100).bufferType(IndexBuffer.Builder.IndexType.USHORT).build(this.engine);
    this.indexBuffer.setBuffer(this.engine, localByteBuffer3);
  }
  
  private void initParticle(List<String> paramList)
  {
    if (paramList != null)
    {
      this.mParticleDirList = new ArrayList();
      paramList = new ArrayList(paramList);
      int i = 0;
      while (i < paramList.size())
      {
        this.mParticleDirList.add(((String)paramList.get(i)).substring(0, ((String)paramList.get(i)).lastIndexOf("/")));
        paramList.set(i, FileUtils.getRealPath(this.dataPath + File.separator + (String)paramList.get(i)));
        i += 1;
      }
      this.mParticleSystem.loadParticleData(paramList);
    }
  }
  
  private void loadMaterial()
  {
    this.material = FilamentJavaUtil.loadMaterial(AEModule.getContext(), this.engine, "assets://materials/pointSprites.filamat");
  }
  
  private void resize(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.width == paramInt1) && (this.height == paramInt2) && (this.rotation == paramInt3)) {
      return;
    }
    this.rotation = paramInt3;
    this.width = paramInt1;
    this.height = paramInt2;
    float f = Math.min(paramInt1 / FilamentJavaUtil.getProcessWidth(), 1.0F);
    int i = (int)(paramInt1 * f);
    paramInt1 = (int)(f * paramInt2);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt2 = i + paramInt1;
      paramInt1 = paramInt2 - paramInt1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      double d = paramInt2 / paramInt1;
      this.camera.setProjection(60.0D, d, this.near, this.far, Camera.Fov.VERTICAL);
      this.view.setViewport(new Viewport(0, 0, paramInt2, paramInt1));
      this.surfaceTexture.setDefaultBufferSize(paramInt2, paramInt1);
      return;
      paramInt2 = i;
    }
  }
  
  private void setupFilament()
  {
    this.engine = Engine.create();
    this.renderer = this.engine.createRenderer();
    this.scene = this.engine.createScene();
    this.view = this.engine.createView();
    this.camera = this.engine.createCamera();
    this.lock = new CountDownLatch(1);
    this.mHandler.post(new FilamentParticleFilter.1(this));
    try
    {
      this.lock.await();
      this.surface = new Surface(this.surfaceTexture);
      if (this.swapChain != null) {
        this.engine.destroySwapChain(this.swapChain);
      }
      this.swapChain = this.engine.createSwapChain(this.surface, 1L);
      this.surfaceTexture.setOnFrameAvailableListener(new FilamentParticleFilter.2(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.e(localException);
      }
    }
  }
  
  private void setupScene()
  {
    loadMaterial();
    createMeshForPoints();
    this.renderable = EntityManager.get().create();
    new RenderableManager.Builder(1).boundingBox(new Box(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.01F)).geometry(0, RenderableManager.PrimitiveType.POINTS, this.vertexBuffer, this.indexBuffer, 0, 100).material(0, this.material.getDefaultInstance()).build(this.engine, this.renderable);
    this.scene.addEntity(this.renderable);
  }
  
  private void setupView()
  {
    this.view.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.view.setCamera(this.camera);
    this.view.setScene(this.scene);
  }
  
  private void updateParams(long paramLong)
  {
    List localList = FilamentParticleUtil.getParticles(this.mParticleSystem.advance());
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    this.scene.removeEntity(this.renderable);
    this.engine.destroyVertexBuffer(this.vertexBuffer);
    this.engine.destroyIndexBuffer(this.indexBuffer);
    this.engine.destroyEntity(this.renderable);
    EntityManager.get().destroy(this.renderable);
    createMesh(localList);
    this.renderable = EntityManager.get().create();
    new RenderableManager.Builder(1).boundingBox(new Box(0.0F, 0.0F, 0.0F, 500.0F, 500.0F, 500.0F)).geometry(0, RenderableManager.PrimitiveType.POINTS, this.vertexBuffer, this.indexBuffer, 0, localList.size()).material(0, this.material.getDefaultInstance()).build(this.engine, this.renderable);
    this.scene.addEntity(this.renderable);
  }
  
  public void destroy()
  {
    HandlerUtil.waitDone(this.mHandler);
    this.mHandler.getLooper().quit();
    this.surfaceTexture.setOnFrameAvailableListener(null);
    if (this.swapChain != null)
    {
      this.engine.destroySwapChain(this.swapChain);
      this.engine.flushAndWait();
      this.swapChain = null;
    }
    this.surface.release();
    this.surfaceTexture.release();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.filamentFrame.clear();
    this.mCopyFilter.clearGLSLSelf();
    this.mPreviewFilter.clearGLSLSelf();
    Fence.waitAndDestroy(this.engine.createFence(), Fence.Mode.FLUSH);
    this.engine.destroyEntity(this.renderable);
    this.engine.destroyRenderer(this.renderer);
    this.engine.destroyVertexBuffer(this.vertexBuffer);
    this.engine.destroyIndexBuffer(this.indexBuffer);
    this.engine.destroyMaterial(this.material);
    this.engine.destroyView(this.view);
    this.engine.destroyScene(this.scene);
    this.engine.destroyCamera(this.camera);
    EntityManager.get().destroy(this.renderable);
    this.engine.destroy();
    ARMatrixUtil.stopOrientationSensor();
  }
  
  public void init()
  {
    GlUtil.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    this.mPreviewFilter.apply();
    this.mCopyFilter.apply();
    setupFilament();
    setupView();
    setupScene();
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    resize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getRotation());
    updateParams(paramPTFaceAttr.getTimeStamp());
    if (this.renderer.beginFrame(this.swapChain))
    {
      this.renderer.render(this.view);
      this.renderer.endFrame();
    }
    GlUtil.setBlendMode(true);
    try
    {
      ((Runnable)this.drawQueue.take()).run();
      this.mCopyFilter.RenderProcess(this.filamentFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      GlUtil.setBlendMode(false);
      return paramFrame;
    }
    catch (InterruptedException paramPTFaceAttr)
    {
      for (;;)
      {
        paramPTFaceAttr.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentParticleFilter
 * JD-Core Version:    0.7.0.1
 */
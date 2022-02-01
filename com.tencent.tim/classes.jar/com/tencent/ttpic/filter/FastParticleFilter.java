package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.Shader;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.model.ParticleParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastParticleFilter
{
  private static final String FRAGMENT_SHADER = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec4 vColor;\nvarying vec2 vTexCoords;\nvarying float stickerIndex;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nvoid main() {\n\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n    vec4 blendColor = vec4(0.68, 0.32, 0.21, 1.0);\n\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, vTexCoords);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, vTexCoords);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, vTexCoords);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, vTexCoords);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, vTexCoords);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, vTexCoords);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, vTexCoords);\n    } else {\n        texColor = texture2D(inputImageTexture7, vTexCoords);\n    }\n\n    gl_FragColor = vec4(texColor) * vColor;\n\n}";
  private static final int MAX_DRAW_PER_RENDER = 7;
  private static final int MAX_PARTICLE_NUM = 166;
  private static final String VERTEX_SHADER = "attribute float a_stickerIndex;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec4 aColor;\n\nvarying vec2 vTexCoords;\nvarying vec4 vColor;\nvarying float stickerIndex;\n\nvoid main() {\n    gl_Position = position;\n    vTexCoords  = inputTextureCoordinate;\n    vColor = aColor;\n    stickerIndex = a_stickerIndex;\n}";
  private int blendFuncDst = 0;
  private int blendFuncSrc = 0;
  protected int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private Map<String, UniformParam> mParamList;
  protected int mSTextureHandle = -1;
  protected double mScreenScale;
  private Shader shader;
  protected int width;
  
  public FastParticleFilter()
  {
    this(new Shader(BaseFilter.nativeDecrypt("attribute float a_stickerIndex;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec4 aColor;\n\nvarying vec2 vTexCoords;\nvarying vec4 vColor;\nvarying float stickerIndex;\n\nvoid main() {\n    gl_Position = position;\n    vTexCoords  = inputTextureCoordinate;\n    vColor = aColor;\n    stickerIndex = a_stickerIndex;\n}"), BaseFilter.nativeDecrypt("#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec4 vColor;\nvarying vec2 vTexCoords;\nvarying float stickerIndex;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nvoid main() {\n\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n    vec4 blendColor = vec4(0.68, 0.32, 0.21, 1.0);\n\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, vTexCoords);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, vTexCoords);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, vTexCoords);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, vTexCoords);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, vTexCoords);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, vTexCoords);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, vTexCoords);\n    } else {\n        texColor = texture2D(inputImageTexture7, vTexCoords);\n    }\n\n    gl_FragColor = vec4(texColor) * vColor;\n\n}")));
  }
  
  private FastParticleFilter(Shader paramShader)
  {
    this.shader = paramShader;
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
  }
  
  private boolean mergeRenderParams(List<ParticleParam> paramList)
  {
    boolean bool = false;
    int n = 0;
    if (!paramList.isEmpty())
    {
      int i = 0;
      int j = 0;
      while (i < paramList.size())
      {
        j += ((ParticleParam)paramList.get(i)).coordNum;
        i += 1;
      }
      setCoordNum(j);
      setBlendFuncSrc(((ParticleParam)paramList.get(0)).blendFuncSrc);
      setBlendFuncDst(((ParticleParam)paramList.get(0)).blendFuncDst);
      float[] arrayOfFloat = new float[j * 3];
      int k = 0;
      i = 0;
      int m;
      while (k < paramList.size())
      {
        m = 0;
        while (m < ((ParticleParam)paramList.get(k)).position.length)
        {
          arrayOfFloat[i] = ((ParticleParam)paramList.get(k)).position[m];
          i += 1;
          m += 1;
        }
        k += 1;
      }
      addAttribParam(new AttributeParam("position", arrayOfFloat, 3));
      arrayOfFloat = new float[j * 2];
      k = 0;
      i = 0;
      while (k < paramList.size())
      {
        m = 0;
        while (m < ((ParticleParam)paramList.get(k)).inputTextureCoordinate.length)
        {
          arrayOfFloat[i] = ((ParticleParam)paramList.get(k)).inputTextureCoordinate[m];
          i += 1;
          m += 1;
        }
        k += 1;
      }
      setTexCords(arrayOfFloat);
      arrayOfFloat = new float[j * 4];
      k = 0;
      i = 0;
      while (k < paramList.size())
      {
        m = 0;
        while (m < ((ParticleParam)paramList.get(k)).aColor.length)
        {
          arrayOfFloat[i] = ((ParticleParam)paramList.get(k)).aColor[m];
          i += 1;
          m += 1;
        }
        k += 1;
      }
      addAttribParam(new AttributeParam("aColor", arrayOfFloat, 4));
      arrayOfFloat = new float[j];
      j = 0;
      i = 0;
      while (j < paramList.size())
      {
        k = 0;
        while (k < ((ParticleParam)paramList.get(j)).coordNum)
        {
          arrayOfFloat[i] = (j + 0.5F);
          i += 1;
          k += 1;
        }
        j += 1;
      }
      addAttribParam(new AttributeParam("a_stickerIndex", arrayOfFloat, 1));
      i = n;
      while (i < paramList.size())
      {
        addParam(new UniformParam.TextureParam("inputImageTexture" + i, ((ParticleParam)paramList.get(i)).texture, 33984 + i + 1));
        i += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  private List<List<ParticleParam>> splitRenderParams(List<ParticleParam> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    Object localObject = (ParticleParam)paramList.get(0);
    int m = ((ParticleParam)localObject).blendFuncSrc;
    int k = ((ParticleParam)localObject).blendFuncDst;
    int j = ((ParticleParam)localObject).maxParticleNum;
    localObject = new ArrayList();
    int i1 = 0;
    int i = 1;
    while (i < paramList.size())
    {
      ParticleParam localParticleParam = (ParticleParam)paramList.get(i);
      j += localParticleParam.maxParticleNum;
      int i2;
      int n;
      if ((i - i1 + 1 <= 7) && (j <= 166) && (localParticleParam.blendFuncSrc == m))
      {
        i2 = i1;
        n = k;
        if (localParticleParam.blendFuncDst == k) {}
      }
      else
      {
        ((List)localObject).add(paramList.subList(i1, i));
        j = localParticleParam.maxParticleNum;
        m = localParticleParam.blendFuncSrc;
        n = localParticleParam.blendFuncDst;
        i2 = i;
      }
      i += 1;
      i1 = i2;
      k = n;
    }
    ((List)localObject).add(paramList.subList(i1, paramList.size()));
    return localObject;
  }
  
  public void OnDrawFrameGLSL()
  {
    this.shader.bind();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).setParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext())
    {
      AttributeParam localAttributeParam = (AttributeParam)localIterator.next();
      if (localAttributeParam.handle >= 0) {
        localAttributeParam.setParams(this.shader.getShaderProgram());
      }
    }
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat, false);
      this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramAttributeParam.vertices);
    localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
  }
  
  public void addParam(UniformParam paramUniformParam)
  {
    if (paramUniformParam == null) {
      return;
    }
    UniformParam localUniformParam = (UniformParam)this.mParamList.get(paramUniformParam.name);
    if (localUniformParam == null)
    {
      this.mParamList.put(paramUniformParam.name, paramUniformParam);
      return;
    }
    paramUniformParam.handle = localUniformParam.handle;
    this.mParamList.put(paramUniformParam.name, paramUniformParam);
  }
  
  public void applyGLSLFilter()
  {
    initAttribParams();
    this.shader.compile();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
  }
  
  public void clearGLSLSelf()
  {
    this.shader.clear();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
  }
  
  public int getBlendFuncDst()
  {
    return this.blendFuncDst;
  }
  
  public int getBlendFuncSrc()
  {
    return this.blendFuncSrc;
  }
  
  public void initAttribParams()
  {
    setCoordNum(6);
    addAttribParam(new AttributeParam("position", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
    addAttribParam(new AttributeParam("inputTextureCoordinate", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("aColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 4));
    initParams();
  }
  
  public void initParams()
  {
    int i = 0;
    while (i <= 7)
    {
      addParam(new UniformParam.TextureParam("inputImageTexture" + i, 0, 33986));
      i += 1;
    }
  }
  
  public void render(List<ParticleParam> paramList, Frame paramFrame)
  {
    if (paramList.size() > 0)
    {
      Collections.sort(paramList, new FastParticleFilter.1(this));
      Collections.sort(paramList, new FastParticleFilter.2(this));
      paramList = splitRenderParams(paramList).iterator();
      while (paramList.hasNext()) {
        if (mergeRenderParams((List)paramList.next()))
        {
          GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
          GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
          OnDrawFrameGLSL();
          renderTexture(paramFrame);
        }
      }
    }
  }
  
  public void renderTexture(Frame paramFrame)
  {
    boolean bool = GlUtil.curBlendModeEnabled;
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(getBlendFuncSrc(), getBlendFuncDst());
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramFrame.getTextureId());
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glDrawArrays(4, 0, this.mCoordNum);
    GLES20.glFlush();
    GlUtil.setBlendMode(bool);
  }
  
  public void setBlendFuncDst(int paramInt)
  {
    this.blendFuncDst = paramInt;
  }
  
  public void setBlendFuncSrc(int paramInt)
  {
    this.blendFuncSrc = paramInt;
  }
  
  public boolean setColors(float[] paramArrayOfFloat)
  {
    addAttribParam("aColor", paramArrayOfFloat);
    return true;
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastParticleFilter
 * JD-Core Version:    0.7.0.1
 */
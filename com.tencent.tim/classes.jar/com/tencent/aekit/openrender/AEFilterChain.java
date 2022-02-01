package com.tencent.aekit.openrender;

import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterChain
{
  private static final String TAG = AEFilterChain.class.getSimpleName();
  private static final String fragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
  private static final String vertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<AEChainI> filterList = new ArrayList();
  
  private void copy(Frame paramFrame, int paramInt)
  {
    if (this.copyFilter == null) {
      return;
    }
    Frame localFrame = new Frame();
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramInt, 0.0D, localFrame);
    localFrame.clear();
  }
  
  public void add(int paramInt, AEChainI paramAEChainI)
  {
    this.filterList.add(paramInt, paramAEChainI);
  }
  
  public void add(AEChainI paramAEChainI)
  {
    this.filterList.add(paramAEChainI);
  }
  
  public void add(List<? extends AEChainI> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AEChainI localAEChainI = (AEChainI)paramList.next();
        this.filterList.add(localAEChainI);
      }
    }
  }
  
  public void clearFilterList()
  {
    this.filterList.clear();
  }
  
  public boolean containFilter(AEChainI paramAEChainI)
  {
    return (this.filterList != null) && (this.filterList.contains(paramAEChainI));
  }
  
  public void destroy()
  {
    clearFilterList();
    this.copyFilter.clearGLSLSelf();
  }
  
  public int indexOfFilter(AEChainI paramAEChainI)
  {
    if (containFilter(paramAEChainI)) {
      return this.filterList.indexOf(paramAEChainI);
    }
    return -1;
  }
  
  public void init()
  {
    this.copyFilter.ApplyGLSLFilter();
  }
  
  public Frame process(Frame paramFrame)
  {
    Iterator localIterator = this.filterList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEChainI)localIterator.next();
      if ((localObject != null) && (((AEChainI)localObject).isApplied()))
      {
        localObject = ((AEChainI)localObject).render(paramFrame);
        if ((localObject != paramFrame) && (!paramFrame.unlock())) {
          paramFrame.clear();
        }
        paramFrame = (Frame)localObject;
      }
    }
    return paramFrame;
  }
  
  public void process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = new Frame();
    ((Frame)localObject1).setSizedTexture(paramInt1, paramInt3, paramInt4);
    if (this.filterList.isEmpty())
    {
      copy((Frame)localObject1, paramInt2);
      ((Frame)localObject1).clear();
    }
    do
    {
      return;
      Iterator localIterator = this.filterList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (AEChainI)localIterator.next();
        if ((localObject3 != null) && (((AEChainI)localObject3).isApplied()))
        {
          Object localObject2 = localObject3.getClass().getSimpleName() + "@" + localObject3.hashCode();
          AEProfiler.getInstance().start((String)localObject2, true);
          Frame localFrame1 = ((AEChainI)localObject3).render((Frame)localObject1);
          long l = AEProfiler.getInstance().end((String)localObject2, true);
          AEProfiler.getInstance().add(2, (String)localObject2, l);
          if (localFrame1 != localObject1)
          {
            localObject2 = ((Frame)localObject1).nextFrame;
            localObject3 = localObject1;
            while (localObject2 != null)
            {
              if (localFrame1 == localObject2)
              {
                ((Frame)localObject3).nextFrame = localFrame1.nextFrame;
                localFrame1.nextFrame = null;
              }
              Frame localFrame2 = ((Frame)localObject2).nextFrame;
              localObject3 = localObject2;
              localObject2 = localFrame2;
            }
            if (!((Frame)localObject1).unlock()) {
              ((Frame)localObject1).clear();
            }
          }
          localObject1 = localFrame1;
        }
      }
      copy((Frame)localObject1, paramInt2);
    } while (((Frame)localObject1).unlock());
    ((Frame)localObject1).clear();
  }
  
  public void process(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AEChainI... paramVarArgs)
  {
    Log.i(TAG, "[process] + BEGIN, width = " + paramInt3 + ", height = " + paramInt4);
    Object localObject1 = new Frame();
    ((Frame)localObject1).setSizedTexture(paramInt1, paramInt3, paramInt4);
    paramInt3 = paramVarArgs.length;
    paramInt1 = 0;
    if (paramInt1 < paramInt3)
    {
      AEChainI localAEChainI = paramVarArgs[paramInt1];
      Object localObject2 = localObject1;
      if (localAEChainI != null)
      {
        if (localAEChainI.isApplied()) {
          break label103;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        paramInt1 += 1;
        localObject1 = localObject2;
        break;
        label103:
        localObject2 = localAEChainI.render((Frame)localObject1);
        Log.d(TAG, "[process] filter = " + localAEChainI);
        if ((localObject2 != localObject1) && (!((Frame)localObject1).unlock())) {
          ((Frame)localObject1).clear();
        }
      }
    }
    copy((Frame)localObject1, paramInt2);
    if (!((Frame)localObject1).unlock()) {
      ((Frame)localObject1).clear();
    }
    Log.i(TAG, "[process] + END");
  }
  
  public void remove(int paramInt)
  {
    if (paramInt >= 0) {
      this.filterList.remove(paramInt);
    }
  }
  
  public void remove(AEChainI paramAEChainI)
  {
    int i = this.filterList.indexOf(paramAEChainI);
    if (i >= 0) {
      this.filterList.remove(i);
    }
  }
  
  public void setFilterList(List<AEChainI> paramList)
  {
    this.filterList = paramList;
  }
  
  public String toString()
  {
    return "AEFilterChain{filterList=" + this.filterList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.AEFilterChain
 * JD-Core Version:    0.7.0.1
 */
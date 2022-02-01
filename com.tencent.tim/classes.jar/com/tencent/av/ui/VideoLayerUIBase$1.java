package com.tencent.av.ui;

import com.tencent.av.VideoController;
import iiv;

class VideoLayerUIBase$1
  implements Runnable
{
  VideoLayerUIBase$1(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      Object localObject = this.this$0.a.b();
      if ((((iiv)localObject).uinType == 1011) && (((iiv)localObject).anf != 3)) {}
      localObject = ((iiv)localObject).peerUin;
      this.this$0.a.hR((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.1
 * JD-Core Version:    0.7.0.1
 */
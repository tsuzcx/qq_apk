package com.tencent.token.ui;

import com.tencent.token.utils.i;

final class hh
  implements Runnable
{
  hh(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void run()
  {
    if (!i.a())
    {
      FaceRecognitionCameraActivityOld.access$902(this.a, false);
      return;
    }
    if (i.b() < 2097152L)
    {
      FaceRecognitionCameraActivityOld.access$902(this.a, false);
      return;
    }
    FaceRecognitionCameraActivityOld.access$902(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hh
 * JD-Core Version:    0.7.0.1
 */
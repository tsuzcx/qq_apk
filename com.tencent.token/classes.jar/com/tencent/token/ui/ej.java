package com.tencent.token.ui;

import com.tencent.token.utils.i;

final class ej
  implements Runnable
{
  ej(FacePKCameraActivity paramFacePKCameraActivity) {}
  
  public final void run()
  {
    if (!i.a())
    {
      FacePKCameraActivity.access$502(this.a, false);
      return;
    }
    if (i.b() < 2097152L)
    {
      FacePKCameraActivity.access$502(this.a, false);
      return;
    }
    FacePKCameraActivity.access$502(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ej
 * JD-Core Version:    0.7.0.1
 */
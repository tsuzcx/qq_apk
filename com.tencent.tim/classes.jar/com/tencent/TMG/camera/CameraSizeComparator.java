package com.tencent.TMG.camera;

import android.hardware.Camera.Size;
import java.util.Comparator;

public class CameraSizeComparator
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Camera.Size)paramObject1;
    paramObject2 = (Camera.Size)paramObject2;
    if (paramObject1.width < paramObject2.width) {}
    do
    {
      return -1;
      if (paramObject1.width > paramObject2.width) {
        return 1;
      }
    } while (paramObject1.height < paramObject2.height);
    if (paramObject1.height > paramObject2.height) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.camera.CameraSizeComparator
 * JD-Core Version:    0.7.0.1
 */
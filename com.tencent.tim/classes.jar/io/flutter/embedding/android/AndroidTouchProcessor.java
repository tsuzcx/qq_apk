package io.flutter.embedding.android;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AndroidTouchProcessor
{
  private static final int BYTES_PER_FIELD = 8;
  private static final int POINTER_DATA_FIELD_COUNT = 24;
  private static final int POINTER_DATA_FLAG_BATCHED = 1;
  @NonNull
  private final FlutterRenderer renderer;
  
  public AndroidTouchProcessor(@NonNull FlutterRenderer paramFlutterRenderer)
  {
    this.renderer = paramFlutterRenderer;
  }
  
  private void addPointerForIndex(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    if (paramInt2 == -1) {
      return;
    }
    int j = getPointerDeviceTypeForToolType(paramMotionEvent.getToolType(paramInt1));
    int i;
    label125:
    double d2;
    double d1;
    if (paramMotionEvent.getActionMasked() == 8)
    {
      i = 1;
      paramByteBuffer.putLong(paramMotionEvent.getEventTime() * 1000L);
      paramByteBuffer.putLong(paramInt2);
      paramByteBuffer.putLong(j);
      paramByteBuffer.putLong(i);
      paramByteBuffer.putLong(paramMotionEvent.getPointerId(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getX(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getY(paramInt1));
      if (j != 1) {
        break label359;
      }
      paramByteBuffer.putLong(paramMotionEvent.getButtonState() & 0x1F);
      paramByteBuffer.putLong(0L);
      paramByteBuffer.putDouble(paramMotionEvent.getPressure(paramInt1));
      if (paramMotionEvent.getDevice() == null) {
        break label394;
      }
      InputDevice.MotionRange localMotionRange = paramMotionEvent.getDevice().getMotionRange(2);
      if (localMotionRange == null) {
        break label394;
      }
      d2 = localMotionRange.getMin();
      d1 = localMotionRange.getMax();
      label182:
      paramByteBuffer.putDouble(d2);
      paramByteBuffer.putDouble(d1);
      if (j != 2) {
        break label403;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(24, paramInt1));
      paramByteBuffer.putDouble(0.0D);
      label225:
      paramByteBuffer.putDouble(paramMotionEvent.getSize(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMajor(paramInt1));
      paramByteBuffer.putDouble(paramMotionEvent.getToolMinor(paramInt1));
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(8, paramInt1));
      if (j != 2) {
        break label420;
      }
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(25, paramInt1));
    }
    for (;;)
    {
      paramByteBuffer.putLong(paramInt3);
      if (i != 1) {
        break label430;
      }
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(10));
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(9));
      return;
      i = 0;
      break;
      label359:
      if (j == 2)
      {
        paramByteBuffer.putLong(paramMotionEvent.getButtonState() >> 4 & 0xF);
        break label125;
      }
      paramByteBuffer.putLong(0L);
      break label125;
      label394:
      d1 = 1.0D;
      d2 = 0.0D;
      break label182;
      label403:
      paramByteBuffer.putDouble(0.0D);
      paramByteBuffer.putDouble(0.0D);
      break label225;
      label420:
      paramByteBuffer.putDouble(0.0D);
    }
    label430:
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
  }
  
  @PointerChange
  private int getPointerChangeForAction(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return 4;
      if (paramInt == 1) {
        return 6;
      }
    } while (paramInt == 5);
    if (paramInt == 6) {
      return 6;
    }
    if (paramInt == 2) {
      return 5;
    }
    if (paramInt == 7) {
      return 3;
    }
    if (paramInt == 3) {
      return 0;
    }
    if (paramInt == 8) {
      return 3;
    }
    return -1;
  }
  
  @PointerDeviceKind
  private int getPointerDeviceTypeForToolType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 4: 
      return 3;
    case 3: 
      return 1;
    case 2: 
      return 2;
    }
    return 0;
  }
  
  public boolean onGenericMotionEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((Build.VERSION.SDK_INT >= 18) && (paramMotionEvent.isFromSource(2)))
    {
      i = 1;
      if ((paramMotionEvent.getActionMasked() != 7) && (paramMotionEvent.getActionMasked() != 8)) {
        break label53;
      }
    }
    label53:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j != 0)) {
        break label58;
      }
      return false;
      i = 0;
      break;
    }
    label58:
    int i = getPointerChangeForAction(paramMotionEvent.getActionMasked());
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramMotionEvent.getPointerCount() * 24 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), i, 0, localByteBuffer);
    if (localByteBuffer.position() % 192 == 0)
    {
      this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
      return true;
    }
    throw new AssertionError("Packet position is not on field boundary.");
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getPointerCount();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(k * 24 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramMotionEvent.getActionMasked();
    int m = getPointerChangeForAction(paramMotionEvent.getActionMasked());
    int i;
    if ((j == 0) || (j == 5))
    {
      i = 1;
      if ((i != 0) || ((j != 1) && (j != 6))) {
        break label122;
      }
      j = 1;
      label71:
      if (i == 0) {
        break label127;
      }
      addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, localByteBuffer);
    }
    for (;;)
    {
      if (localByteBuffer.position() % 192 != 0) {
        break label216;
      }
      this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
      return true;
      i = 0;
      break;
      label122:
      j = 0;
      break label71;
      label127:
      if (j != 0)
      {
        i = 0;
        while (i < k)
        {
          if ((i != paramMotionEvent.getActionIndex()) && (paramMotionEvent.getToolType(i) == 1)) {
            addPointerForIndex(paramMotionEvent, i, 5, 1, localByteBuffer);
          }
          i += 1;
        }
        addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, localByteBuffer);
      }
      else
      {
        i = 0;
        while (i < k)
        {
          addPointerForIndex(paramMotionEvent, i, m, 0, localByteBuffer);
          i += 1;
        }
      }
    }
    label216:
    throw new AssertionError("Packet position is not on field boundary");
  }
  
  static @interface PointerChange
  {
    public static final int ADD = 1;
    public static final int CANCEL = 0;
    public static final int DOWN = 4;
    public static final int HOVER = 3;
    public static final int MOVE = 5;
    public static final int REMOVE = 2;
    public static final int UP = 6;
  }
  
  static @interface PointerDeviceKind
  {
    public static final int INVERTED_STYLUS = 3;
    public static final int MOUSE = 1;
    public static final int STYLUS = 2;
    public static final int TOUCH = 0;
    public static final int UNKNOWN = 4;
  }
  
  static @interface PointerSignalKind
  {
    public static final int NONE = 0;
    public static final int SCROLL = 1;
    public static final int UNKNOWN = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidTouchProcessor
 * JD-Core Version:    0.7.0.1
 */
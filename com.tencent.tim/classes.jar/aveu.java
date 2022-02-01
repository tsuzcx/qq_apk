import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aveu
  implements avev.c
{
  aveu(aveo paramaveo) {}
  
  public void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int j = 0;
    String str;
    if (j < k)
    {
      str = paramArrayOfString[j];
      QLog.i("AVEngineWalper", 1, String.format("onEndpointsUpdateInfo|eventid=%d, id=%s", new Object[] { Integer.valueOf(paramInt), str }));
      if (!this.b.jd.containsKey(str)) {
        break label237;
      }
    }
    label237:
    for (int i = ((Integer)this.b.jd.get(str)).intValue();; i = 0)
    {
      switch (paramInt)
      {
      default: 
        label116:
        if (i != 0) {
          this.b.jd.put(str, Integer.valueOf(i));
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        i |= 0x20;
        break label116;
        i &= 0xFFFFFFDF;
        break label116;
        i |= 0x1;
        break label116;
        i &= 0xFFFFFFFE;
        break label116;
        if (this.b.jd.containsKey(str)) {
          this.b.jd.remove(str);
        }
      }
      if (this.b.b != null) {
        this.b.b.f(paramInt, paramArrayOfString);
      }
      return;
    }
  }
  
  public void onExitRoomComplete()
  {
    QLog.e("AVEngineWalper", 1, "onExitRoomComplete");
    if (this.b.b != null) {
      this.b.b.onExitRoomComplete();
    }
  }
  
  public void onRoomDisconnect(int paramInt, String paramString)
  {
    QLog.e("AVEngineWalper", 1, "onRoomDisconnect   result=" + paramInt + ", errinfo=" + paramString);
    if (this.b.b != null) {
      this.b.b.bO(paramInt, paramString);
    }
  }
  
  public void onSemiAutoRecvCameraVideo(String[] paramArrayOfString)
  {
    QLog.e("AVEngineWalper", 1, "onSemiAutoRecvCameraVideo");
    if (this.b.b != null) {
      this.b.b.onSemiAutoRecvCameraVideo(paramArrayOfString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveu
 * JD-Core Version:    0.7.0.1
 */
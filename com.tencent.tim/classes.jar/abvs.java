import com.tencent.qphone.base.util.QLog;

class abvs
  implements abvy.b
{
  abvs(abvq paramabvq) {}
  
  public void onEnterRoomComplete(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      QLog.e("AVEngineWalper", 1, "EnterRoom successfully!!!");
    }
    for (;;)
    {
      if (this.b.b != null) {
        this.b.b.bN(paramInt, paramString);
      }
      return;
      QLog.e("AVEngineWalper", 1, "enter room failed. result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvs
 * JD-Core Version:    0.7.0.1
 */
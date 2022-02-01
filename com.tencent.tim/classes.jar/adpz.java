import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1;

public class adpz
  extends adqb.a
{
  public adpz(ArkAiDictUpdateMgr.8 param8) {}
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new ArkAiDictUpdateMgr.8.1.1(this, paramArrayOfByte, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpz
 * JD-Core Version:    0.7.0.1
 */
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity.1.1;

public class rem
  implements aaza.c
{
  public rem(EditWebVideoActivity paramEditWebVideoActivity) {}
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = ((ren)this.a.a).bqC;
    EditWebVideoActivity.a(this.a, paramString1);
    EditWebVideoActivity.a(this.a, paramArrayOfByte1);
    EditWebVideoActivity.b(this.a, HexUtil.bytes2HexStr(EditWebVideoActivity.a(this.a)));
    paramString1 = this.a;
    if (i <= 0) {}
    for (;;)
    {
      EditWebVideoActivity.a(paramString1, paramInt3);
      EditWebVideoActivity.c(this.a, paramString2);
      EditWebVideoActivity.b(this.a, paramArrayOfByte2);
      EditWebVideoActivity.b(this.a, paramInt1);
      EditWebVideoActivity.c(this.a, paramInt2);
      EditWebVideoActivity.a(this.a).sendEmptyMessage(1002);
      return;
      paramInt3 = i;
    }
  }
  
  public void onError(int paramInt)
  {
    this.a.runOnUiThread(new EditWebVideoActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rem
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class akxg
  implements aoqm.a
{
  akxg(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    int j = 0;
    if (j < paramb.Hf.size())
    {
      parama = (aoql.b.m)paramb.Hf.get(j);
      int i = -1;
      if ((parama instanceof aoql.b.e)) {
        i = ((aoql.b.e)parama).result;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.val$selfUin + ", friendUin:" + this.SO + ", md5:" + this.a.rawMd5 + ", commonInfo:" + parama.toString());
        }
        j += 1;
        break;
        if ((parama instanceof aoql.b.b)) {
          i = ((aoql.b.b)parama).result;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxg
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.a;
import com.tencent.qphone.base.util.QLog;

public class xps
  extends TribeShortVideoItemBuilder.a
{
  public xps(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder)
  {
    super(paramTribeShortVideoItemBuilder);
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeShortVideoItemBuilder", 2, "Download video failed,vid=" + paramString1);
    }
    this.this$0.a(this.b, this.Jl);
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeShortVideoItemBuilder", 2, "get video download finish,vid=" + paramString1);
    }
    if (!paramString1.equals(this.mVid)) {}
  }
  
  public void p(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeShortVideoItemBuilder", 2, "Download video onPause,vid=" + paramString1);
    }
    this.this$0.a(this.b, this.Jl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xps
 * JD-Core Version:    0.7.0.1
 */
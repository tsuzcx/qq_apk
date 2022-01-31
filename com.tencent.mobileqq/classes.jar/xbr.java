import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.qphone.base.util.QLog;

public class xbr
  extends xal
  implements wyr
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public SubtitleLayout a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public xbr(@NonNull xan paramxan, byte[] paramArrayOfByte)
  {
    super(paramxan);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setVisibility(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131377269));
    QQStoryContext.a();
    QQStoryContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null)
    {
      wxe.b("Q.qqstory.publish.edit.Subtitle", "makeSureInitLayout");
      ViewParent localViewParent = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localViewParent == null) || (!(localViewParent instanceof ViewGroup))) {
        break label95;
      }
    }
    label95:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = ((SubtitleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = ((SubtitleLayout)a(2131377268)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a(this.jdField_a_of_type_ArrayOfByte);
      a(wyr.class, this);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(0);
  }
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    super.a(paramInt, paramxlb);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null) || (this.jdField_a_of_type_ArrayOfByte == null)) {
      wxe.d("Q.qqstory.publish.edit.Subtitle", "editVideoPrePublish but subtitle layout is null");
    }
    for (;;)
    {
      return;
      try
      {
        String str = Base64.encodeToString(this.jdField_a_of_type_ArrayOfByte, 0);
        if (!TextUtils.isEmpty(str))
        {
          paramxlb.a.putExtra("subtitleData", str);
          QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode :" + str.length());
          return;
        }
      }
      catch (Exception paramxlb)
      {
        QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode exception:" + paramxlb.toString());
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setTimeStamp(paramLong);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    a(0);
    return true;
  }
  
  public void aa_()
  {
    super.aa_();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.d();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.Subtitle", 2, "videoplayer start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = null;
    }
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbr
 * JD-Core Version:    0.7.0.1
 */
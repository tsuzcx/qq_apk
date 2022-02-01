import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class trs
{
  @Nullable
  private trt a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((tqi.a().a() == 1) && (tqi.f()))
    {
      localMaterialData = tqi.a().a();
      str = tqi.a().a(localMaterialData);
      i = tqi.a().b();
      if (!tqi.a(i)) {}
    }
    while (!QLog.isColorLevel())
    {
      MaterialData localMaterialData;
      String str;
      int i;
      return;
      if (auog.a(str))
      {
        this.a = new trt(paramActivity, paramListView, str);
        this.a.a(i);
        if (localMaterialData != null) {
          tny.b(localMaterialData, true, "no error");
        }
        tqi.a().a = this;
      }
      for (;;)
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "preview mode value = " + tqi.a().g());
        tqi.a().a();
        return;
        tqi.a().b(3);
        tqk.a.a(localMaterialData, false, "supermask path not exist");
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + tqi.a().a() + " Aladdin: " + tqi.f());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (trt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trs
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class zbr
  implements zbx.a
{
  zbr(zbq paramzbq) {}
  
  public boolean Vg()
  {
    zbm localzbm = this.this$0.a(3);
    zbq.b localb = this.this$0.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "isMayKnowEntryShown, canBeShown = " + localzbm.bqw + ", flagValue = " + localb.M);
    }
    return (localzbm.bqw) && (localb.M == 0);
  }
  
  public void gY(List<MayKnowRecommend> paramList)
  {
    Object localObject2 = this.this$0.a(3);
    boolean bool3 = ((zbm)localObject2).bqw;
    Object localObject1 = ((zbm)localObject2).extraInfo;
    Object localObject3;
    boolean bool2;
    boolean bool1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((zbm)localObject2).title = zbq.a(this.this$0).getApp().getResources().getString(2131701327);
      ((zbm)localObject2).subTitle = "";
      ((zbm)localObject2).extraInfo = paramList;
      localObject3 = (achg)zbq.a(this.this$0).getManager(159);
      if (localObject3 == null) {
        break label262;
      }
      bool2 = ((achg)localObject3).kl("sp_mayknow_entry_list_recommend");
      bool1 = ((achg)localObject3).kl("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      label128:
      Object localObject4;
      if ((bool1) && (!bool2))
      {
        ((zbm)localObject2).bqw = true;
        zbq.a(this.this$0);
        if (QLog.isColorLevel())
        {
          localObject3 = Locale.getDefault();
          bool1 = ((zbm)localObject2).bqw;
          localObject4 = ((zbm)localObject2).extraInfo;
          localObject2 = ((zbm)localObject2).subTitle;
          if (paramList == null) {
            break label257;
          }
        }
      }
      label257:
      for (int i = paramList.size();; i = 0)
      {
        QLog.i("CTEntryMng", 2, String.format((Locale)localObject3, "updateMayKnow pre: [%s,%s], cur: [%s,%s], subtitle: %s recommends:%s", new Object[] { Boolean.valueOf(bool3), localObject1, Boolean.valueOf(bool1), localObject4, localObject2, Integer.valueOf(i) }));
        return;
        ((zbm)localObject2).extraInfo = null;
        ((zbm)localObject2).subTitle = null;
        break;
        ((zbm)localObject2).bqw = false;
        break label128;
      }
      label262:
      bool1 = true;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbr
 * JD-Core Version:    0.7.0.1
 */
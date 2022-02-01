import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class avkd
  implements View.OnClickListener
{
  List<Integer> LC = new ArrayList();
  List<String> LD = new ArrayList();
  avkd.a a = null;
  boolean ach = false;
  int exk = 1;
  int exl = -1;
  ShareActionSheet i = null;
  AppRuntime mAppRuntime = null;
  
  public avkd(Activity paramActivity, avkd.a parama, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.exk = paramInt1;
    this.a = parama;
    this.exl = paramInt2;
    this.mAppRuntime = paramAppRuntime;
    if (this.i == null)
    {
      parama = new ShareActionSheetV2.Param();
      parama.context = paramActivity;
      this.i = ShareActionSheetFactory.create(parama);
      this.i.setActionSheetTitle(paramActivity.getString(2131694193));
      this.i.setItemClickListenerV2(new avke(this));
    }
    eAw();
  }
  
  private void abK(int paramInt)
  {
    Object localObject1 = null;
    this.exk = paramInt;
    if (this.a != null)
    {
      localObject1 = this.a.b();
      if (localObject1 != null)
      {
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qfav");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      }
      this.i.setIntentForStartForwardRecentActivity((Intent)localObject1);
    }
    Object localObject2 = this.i;
    if (localObject1 != null)
    {
      paramInt = 0;
      if (localObject1 == null) {
        break label351;
      }
    }
    label351:
    for (int j = 0;; j = 8)
    {
      ((ShareActionSheet)localObject2).setRowVisibility(paramInt, j, 0);
      localObject1 = new ArrayList();
      aqly.a(2, (ArrayList)localObject1);
      if ((this.exk & 0x200) != 0) {
        aqly.a(26, (ArrayList)localObject1);
      }
      if ((this.exk & 0x4000) != 0) {
        aqly.a(64, (ArrayList)localObject1);
      }
      localObject2 = new ArrayList();
      if ((this.exk & 0x80) != 0) {
        aqly.a(70, (ArrayList)localObject2);
      }
      if ((this.exk & 0x100) != 0) {
        aqly.a(82, (ArrayList)localObject2);
      }
      if ((this.exk & 0x8) != 0) {
        aqly.a(39, (ArrayList)localObject2);
      }
      if ((this.exk & 0x400) != 0) {
        aqly.a(130, (ArrayList)localObject2);
      }
      if ((this.exk & 0x8000) != 0) {
        aqly.a(131, (ArrayList)localObject2);
      }
      if ((this.exk & 0x10) != 0) {
        aqly.a(94, (ArrayList)localObject2);
      }
      if ((this.exk & 0x40) != 0) {
        aqly.a(129, (ArrayList)localObject2);
      }
      if ((this.exk & 0x800) != 0) {
        aqly.a(52, (ArrayList)localObject2);
      }
      if ((this.exk & 0x2000) != 0) {
        aqly.a(55, (ArrayList)localObject2);
      }
      if ((this.exk & 0x1000) != 0) {
        aqly.a(56, (ArrayList)localObject2);
      }
      this.i.setActionSheetItems((List)localObject1, (List)localObject2);
      return;
      paramInt = 8;
      break;
    }
  }
  
  private void eAw()
  {
    if (this.a != null) {
      abK(this.a.bs());
    }
  }
  
  public void Fo(int paramInt)
  {
    if (this.i != null)
    {
      abK(paramInt);
      this.i.refresh();
    }
  }
  
  protected void c(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 73: 
      this.a.hJ();
      return;
    case 72: 
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_req", ForwardRecentActivity.bGS);
      localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
      this.a.m(localBundle);
      return;
    case 26: 
      this.a.hL();
      return;
    case 39: 
      this.a.hK();
      return;
    case 130: 
      this.a.hM();
      return;
    case 131: 
      this.a.eAx();
      return;
    case 94: 
      this.a.gu();
      return;
    case 129: 
      this.a.gv();
      return;
    case 70: 
      this.a.gw();
      return;
    case 82: 
      this.a.gx();
      return;
    case 55: 
      this.a.hO();
      return;
    case 52: 
      this.a.hN();
      return;
    case 56: 
      this.a.hP();
      return;
    }
    this.a.iB();
  }
  
  public void dismiss()
  {
    if (this.i != null)
    {
      if (!this.i.isShowing()) {
        break label48;
      }
      this.i.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.i = null;
      return;
      label48:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.i != null) && (!this.i.isShowing()))
    {
      this.ach = false;
      eAw();
      this.i.refresh();
      this.i.show();
      this.a.onShow();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract Intent b();
    
    public abstract int bs();
    
    public abstract void eAx();
    
    public abstract void gu();
    
    public abstract void gv();
    
    public abstract void gw();
    
    public abstract void gx();
    
    public abstract void hJ();
    
    public abstract void hK();
    
    public abstract void hL();
    
    public abstract void hM();
    
    public abstract void hN();
    
    public abstract void hO();
    
    public abstract void hP();
    
    public abstract void iB();
    
    public abstract void m(Bundle paramBundle);
    
    public abstract void onShow();
  }
  
  public static class b
    implements avkd.a
  {
    public Intent b()
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("forward_type", 22);
      localIntent.putExtra("pluginName", "struct_favorite");
      return localIntent;
    }
    
    public int bs()
    {
      return 0;
    }
    
    public void eAx() {}
    
    public void gu() {}
    
    public void gv() {}
    
    public void gw() {}
    
    public void gx() {}
    
    public void hJ() {}
    
    public void hK() {}
    
    public void hL() {}
    
    public void hM() {}
    
    public void hN() {}
    
    public void hO() {}
    
    public void hP() {}
    
    public void iB() {}
    
    public void m(Bundle paramBundle) {}
    
    public void onShow() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkd
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zca
  extends zbn
  implements Handler.Callback, View.OnClickListener, zbp
{
  protected boolean FD;
  public final auru a;
  public zbq a;
  protected zcb a;
  protected boolean amp = true;
  
  public zca(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  private void cnZ()
  {
    if (this.mApp != null)
    {
      this.jdField_a_of_type_Zbq = ((zbq)this.mApp.getManager(295));
      this.jdField_a_of_type_Zbq.a(this);
      this.jdField_a_of_type_Zbq.Bn(true);
    }
  }
  
  private void coa()
  {
    if (this.jdField_a_of_type_Zbq != null) {
      this.jdField_a_of_type_Zbq.b(this);
    }
    this.jdField_a_of_type_Zbq = null;
  }
  
  private void cob()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.jdField_a_of_type_Zbq.a();
    ContactReportUtils.c(this.mApp, "", "banner_recomlist_dlt");
  }
  
  public void Bi(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zcb != null) {
      this.jdField_a_of_type_Zcb.Bw(paramBoolean);
    }
  }
  
  public void Bm(boolean paramBoolean)
  {
    gs(0L);
  }
  
  public void aJ(QQAppInterface paramQQAppInterface)
  {
    super.aJ(paramQQAppInterface);
    if (this.mApp != paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
      if (this.jdField_a_of_type_Zcb != null) {
        this.jdField_a_of_type_Zcb.bq(paramQQAppInterface);
      }
    }
    cnZ();
    gs(50L);
    paramQQAppInterface = this.jdField_a_of_type_Zbq.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.checkUpdate();
    }
  }
  
  public void bFV()
  {
    gs(200L);
  }
  
  public void bMe()
  {
    super.bMe();
    coa();
    if (this.D != null) {
      this.D.setAdapter(null);
    }
    if (this.jdField_a_of_type_Zcb != null) {
      this.jdField_a_of_type_Zcb.onDestroy();
    }
    this.jdField_a_of_type_Zcb = null;
    this.bj.setVisibility(8);
  }
  
  protected void gs(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "refreshData  hasdata:" + this.jdField_a_of_type_Auru.hasMessages(2) + " mHasPaused:" + this.FD);
    }
    if (this.FD) {}
    while (this.jdField_a_of_type_Auru.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    boolean bool2;
    Object localObject1;
    boolean bool1;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_Auru.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.jdField_a_of_type_Zcb == null)
      {
        this.jdField_a_of_type_Zcb = new zcb(getActivity(), this.mApp, this.D, 1, true);
        this.D.setAdapter(this.jdField_a_of_type_Zcb);
      }
      j = this.jdField_a_of_type_Zcb.getCount();
      bool2 = Vc();
      localObject1 = paramMessage.iterator();
      bool1 = false;
      i = 0;
      label120:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (zbm)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((zbm)localObject2).id != 3) || (!bool2)) {
          break label541;
        }
        bool1 = ((zbm)localObject2).bqy;
        if ((bool1) || (!(((zbm)localObject2).extraInfo instanceof List))) {
          break label538;
        }
        localObject2 = (List)((zbm)localObject2).extraInfo;
        if (((List)localObject2).size() <= 0) {
          break label538;
        }
        this.jdField_a_of_type_Zcb.gJ((List)localObject2);
        i = ((List)localObject2).size();
      }
      break;
    }
    label538:
    label541:
    for (;;)
    {
      break label120;
      if (QLog.isColorLevel()) {
        QLog.d("CTEntryController", 2, "MSG_UPDATE_ENTRY_LIST preCount:" + j + " size:" + i + " userClose:" + bool1 + " shouldShowRecommendEntry: " + bool2);
      }
      if (i > 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.bj.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = wja.dp2px(i * 60 + 28, this.bj.getResources());
        this.bj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.bj.setVisibility(0);
        i = 1;
      }
      while (!this.amp)
      {
        this.amp = true;
        paramMessage = paramMessage.iterator();
        for (;;)
        {
          if (paramMessage.hasNext())
          {
            localObject1 = (zbm)paramMessage.next();
            anot.a(this.mApp, "dc00898", "", "", "0X800979E", "0X800979E", ((zbm)localObject1).id, 0, "", "", "", "");
            continue;
            this.jdField_a_of_type_Zcb.gJ(null);
            this.bj.setVisibility(8);
            if ((j > 0) && (!bool1)) {
              cob();
            }
            i = 0;
            break;
          }
        }
        if (i != 0) {
          ContactReportUtils.c(this.mApp, "", "banner_recomlist_exp");
        }
      }
      if (this.jdField_a_of_type_Zbn$a == null) {
        break;
      }
      this.jdField_a_of_type_Zbn$a.cno();
      return false;
      this.jdField_a_of_type_Auru.removeMessages(2);
      ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
      return false;
      if (this.jdField_a_of_type_Zbq == null) {
        break;
      }
      paramMessage = this.jdField_a_of_type_Zbq.a();
      if (paramMessage == null) {
        break;
      }
      paramMessage.checkUpdate();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView.getId() == 2131376929)
    {
      localIntent = new Intent(this.activity, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      if (this.jdField_a_of_type_Zbq != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = this.jdField_a_of_type_Zbq.a())
    {
      if (localObject != null)
      {
        localObject = ((zbx)localObject).bW();
        if (!((ArrayList)localObject).isEmpty()) {
          localIntent.putExtra("may_know_recmmds", (Serializable)localObject);
        }
      }
      this.activity.startActivity(localIntent);
      ContactReportUtils.c(this.mApp, "", "banner_recomlist_clk");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    cnZ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Auru != null) {
      this.jdField_a_of_type_Auru.removeCallbacksAndMessages(null);
    }
    coa();
    this.jdField_a_of_type_Zbn$a = null;
    if (this.jdField_a_of_type_Zcb != null) {
      this.jdField_a_of_type_Zcb.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    if (this.jdField_a_of_type_Zcb != null) {
      this.jdField_a_of_type_Zcb.onPause();
    }
    this.FD = true;
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onResume");
    }
    this.amp = false;
    if (this.FD)
    {
      if (this.jdField_a_of_type_Zcb != null) {
        this.jdField_a_of_type_Zcb.notifyDataSetChanged();
      }
      gs(500L);
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(3, 500L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zcb != null) {
        this.jdField_a_of_type_Zcb.onResume();
      }
      this.FD = false;
      return;
      gs(0L);
      zbx localzbx = this.jdField_a_of_type_Zbq.a();
      if (localzbx != null) {
        localzbx.checkUpdate();
      }
    }
  }
  
  public void u(View paramView)
  {
    super.u(paramView);
    this.jdField_a_of_type_Zcb = new zcb(getActivity(), this.mApp, this.D, 1, true);
    this.D.setAdapter(this.jdField_a_of_type_Zcb);
    this.uR.setVisibility(0);
    this.Mr.setText(acfp.m(2131708054));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zca
 * JD-Core Version:    0.7.0.1
 */
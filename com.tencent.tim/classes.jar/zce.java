import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.List;

public class zce
  extends zbn
{
  public static boolean bqF;
  private zcd a;
  private zcd.a b = new zcf(this);
  private View.OnClickListener mOnClickListener = new zcg(this);
  
  public zce(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void coc()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.bj.getLayoutParams();
    localLayoutParams.height = wja.dp2px(88.0F, this.bj.getResources());
    this.bj.setLayoutParams(localLayoutParams);
  }
  
  private void refresh()
  {
    if (!Vc()) {
      this.bj.setVisibility(8);
    }
    label125:
    do
    {
      for (;;)
      {
        return;
        Object localObject = (achg)this.mApp.getManager(159);
        if (TextUtils.isEmpty(((achg)localObject).box))
        {
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(false);
          this.uR.setVisibility(8);
          if (this.jdField_a_of_type_Zcd != null) {
            break label125;
          }
        }
        for (int i = 0;; i = this.jdField_a_of_type_Zcd.getCount())
        {
          localObject = ((achg)localObject).R(i);
          if (localObject != null) {
            break label136;
          }
          this.bj.setVisibility(8);
          return;
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this.mOnClickListener);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(true);
          this.uR.setVisibility(0);
          break;
        }
        if (((List)localObject).isEmpty()) {
          break;
        }
        this.bj.setVisibility(0);
        if (this.jdField_a_of_type_Zcd == null)
        {
          this.jdField_a_of_type_Zcd = new zcd(getActivity(), this.mApp, this.D, 4, true, this.b);
          this.jdField_a_of_type_Zcd.ha((List)localObject);
          this.D.setAdapter(this.jdField_a_of_type_Zcd);
        }
        while (((List)localObject).size() == 1)
        {
          coc();
          return;
          this.jdField_a_of_type_Zcd.ha((List)localObject);
        }
      }
    } while (this.jdField_a_of_type_Zcd == null);
    label136:
    this.jdField_a_of_type_Zcd.notifyDataSetChanged();
  }
  
  public void Bi(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zcd != null) {
      this.jdField_a_of_type_Zcd.Bw(paramBoolean);
    }
  }
  
  public void Bm(boolean paramBoolean)
  {
    refresh();
  }
  
  public void aJ(QQAppInterface paramQQAppInterface)
  {
    super.aJ(paramQQAppInterface);
    if (this.mApp != paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
      if (this.jdField_a_of_type_Zcd != null) {
        this.jdField_a_of_type_Zcd.bq(paramQQAppInterface);
      }
    }
    refresh();
  }
  
  public void bMe()
  {
    super.bMe();
    if (this.D != null) {
      this.D.setAdapter(null);
    }
    if (this.jdField_a_of_type_Zcd != null) {
      this.jdField_a_of_type_Zcd.onDestroy();
    }
    this.jdField_a_of_type_Zcd = null;
    this.bj.setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Zcd != null) {
      this.jdField_a_of_type_Zcd.onDestroy();
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((this.jdField_a_of_type_Zcd != null) && (this.jdField_a_of_type_Zcd.in(paramString)))
    {
      ((achg)this.mApp.getManager(159)).cJW();
      refresh();
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    bqF = true;
    refresh();
  }
  
  public void u(View paramView)
  {
    super.u(paramView);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.Wd(false);
    this.Mr.setText(acfp.m(2131713756));
    refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zce
 * JD-Core Version:    0.7.0.1
 */
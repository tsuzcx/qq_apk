import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1;
import com.tencent.mobileqq.extendfriend.wiget.LabelLayout;
import com.tencent.mobileqq.extendfriend.wiget.LabelLayout.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afys
  extends ReportDialog
  implements View.OnClickListener
{
  private View Cp;
  private aftd jdField_a_of_type_Aftd;
  private afys.a jdField_a_of_type_Afys$a;
  private aqdj d;
  private QQAppInterface mApp;
  private int mMode;
  
  public afys(BaseActivity paramBaseActivity, int paramInt, afys.a parama, aftd paramaftd)
  {
    super(paramBaseActivity, 2131756467);
    setCanceledOnTouchOutside(false);
    this.mMode = paramInt;
    this.jdField_a_of_type_Aftd = paramaftd;
    this.jdField_a_of_type_Afys$a = parama;
    if (paramInt == 2)
    {
      this.mApp = paramBaseActivity.app;
      if (this.mApp != null) {
        this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      }
    }
    initView();
  }
  
  private LabelLayout.a a(int paramInt, String paramString)
  {
    Context localContext = getContext();
    String str;
    label48:
    SpannableString localSpannableString;
    int i;
    label69:
    int j;
    if (paramInt == 1)
    {
      str = localContext.getString(2131695654);
      if (!TextUtils.isEmpty(paramString)) {
        break label172;
      }
      paramString = str + " ";
      localSpannableString = new SpannableString(paramString);
      if (paramInt != 1) {
        break label200;
      }
      i = Color.parseColor("#3300CAFC");
      if (paramInt != 1) {
        break label209;
      }
      j = Color.parseColor("#02B2DD");
      label81:
      if (paramInt != 1) {
        break label219;
      }
    }
    label172:
    label200:
    label209:
    label219:
    for (paramString = localContext.getResources().getDrawable(2130846016);; paramString = localContext.getResources().getDrawable(2130846015))
    {
      paramInt = aqnm.dip2px(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new LabelLayout.a();
      paramString.J = localSpannableString;
      paramString.bgColor = i;
      paramString.textColor = j;
      return paramString;
      str = localContext.getString(2131693477);
      break;
      paramString = str + " " + paramString;
      break label48;
      i = Color.parseColor("#33FF80BF");
      break label69;
      j = Color.parseColor("#FF80BF");
      break label81;
    }
  }
  
  private LabelLayout.a a(long paramLong)
  {
    int i = aqnm.dip2px(11.0F);
    Object localObject1 = getContext().getResources().getDrawable(2130846017);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
    String str = getContext().getString(2131695654);
    localObject1 = new SpannableString(str + " " + paramLong);
    ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
    localObject2 = new LabelLayout.a();
    ((LabelLayout.a)localObject2).J = ((CharSequence)localObject1);
    ((LabelLayout.a)localObject2).bgColor = Color.parseColor("#338173FF");
    ((LabelLayout.a)localObject2).textColor = Color.parseColor("#8173FF");
    return localObject2;
  }
  
  public static void a(BaseActivity paramBaseActivity, aftd paramaftd, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()) && (paramaftd != null))
    {
      paramBaseActivity = new afys(paramBaseActivity, 2, null, paramaftd);
      paramBaseActivity.setOnDismissListener(paramOnDismissListener);
      paramBaseActivity.show();
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, afys.a parama)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      new afys(paramBaseActivity, 1, parama, null).show();
    }
  }
  
  private void ddU()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800AE97", "0X800AE97", 0, 0, "", "", "", "");
    destroy();
    dismiss();
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSignalBombDialog.1(this));
  }
  
  private void destroy()
  {
    if (this.d != null) {
      this.d.cancel();
    }
  }
  
  private void initView()
  {
    setContentView(2131561344);
    if (this.mMode == 1)
    {
      findViewById(2131368225).setVisibility(0);
      findViewById(2131378409).setVisibility(8);
      findViewById(2131377981).setOnClickListener(this);
    }
    Object localObject1;
    label653:
    do
    {
      for (;;)
      {
        findViewById(2131364678).setOnClickListener(this);
        localObject1 = findViewById(2131379606);
        if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
          break label687;
        }
        ((View)localObject1).setVisibility(0);
        if ((((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (this.mMode != 1) {
            break;
          }
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131368225);
          ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131368225);
        }
        return;
        if (this.mMode == 2)
        {
          findViewById(2131368225).setVisibility(8);
          findViewById(2131378409).setVisibility(0);
          findViewById(2131377655).setOnClickListener(this);
          this.Cp = findViewById(2131363175);
          this.d = aqdj.a(this.mApp, 1, this.jdField_a_of_type_Aftd.uin);
          this.Cp.setBackgroundDrawable(this.d);
          this.Cp.setOnClickListener(this);
          Object localObject2 = (TextView)findViewById(2131372361);
          if (this.jdField_a_of_type_Aftd.nick == null) {}
          Object localObject3;
          for (localObject1 = "";; localObject1 = this.jdField_a_of_type_Aftd.nick)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject1 = (TextView)findViewById(2131377706);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Aftd.bFv)) {
              break;
            }
            ((TextView)localObject1).setVisibility(8);
            ((TextView)findViewById(2131365980)).setText(String.format(getContext().getString(2131701196), new Object[] { Integer.valueOf(this.jdField_a_of_type_Aftd.distance) }));
            localObject1 = getContext().getResources().getStringArray(2130968662);
            localObject2 = getContext().getResources().getStringArray(2130968661);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Aftd.gender, this.jdField_a_of_type_Aftd.bFu));
            if (this.jdField_a_of_type_Aftd.XK > 0L) {
              ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Aftd.XK));
            }
            if (this.jdField_a_of_type_Aftd.labels == null) {
              break label653;
            }
            Iterator localIterator = this.jdField_a_of_type_Aftd.labels.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!TextUtils.isEmpty(str))
              {
                LabelLayout.a locala = new LabelLayout.a();
                locala.J = str;
                i = locala.J.charAt(0);
                locala.textColor = Color.parseColor(localObject1[(i % localObject1.length)]);
                locala.bgColor = Color.parseColor(localObject2[(i % localObject2.length)]);
                ((ArrayList)localObject3).add(locala);
              }
            }
          }
          ((TextView)localObject1).setVisibility(0);
          if (this.jdField_a_of_type_Aftd.akk()) {}
          for (int i = 2130846073;; i = 2130846075)
          {
            localObject2 = getContext().getResources().getDrawable(i);
            i = aqnm.dip2px(15.0F);
            ((Drawable)localObject2).setBounds(0, 0, i, i);
            localObject2 = new ImageSpan((Drawable)localObject2, 0);
            localObject3 = new SpannableString(" " + this.jdField_a_of_type_Aftd.bFv);
            ((SpannableString)localObject3).setSpan(localObject2, 0, " ".length(), 17);
            ((TextView)localObject1).setText((CharSequence)localObject3);
            break;
          }
          kD((List)localObject3);
        }
      }
    } while (this.mMode != 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131378409);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131378409);
    return;
    label687:
    ((View)localObject1).setVisibility(8);
  }
  
  private void kD(List<LabelLayout.a> paramList)
  {
    LabelLayout localLabelLayout1 = (LabelLayout)findViewById(2131370112);
    LabelLayout localLabelLayout2 = (LabelLayout)findViewById(2131370113);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298637);
      int j = localLabelLayout1.a(i, paramList, true, 12);
      if (j > 0)
      {
        localLabelLayout1.setVisibility(0);
        if (j < paramList.size())
        {
          if (localLabelLayout2.a(i, paramList.subList(j, paramList.size()), true, 12) > 0) {}
          for (i = 0;; i = 8)
          {
            localLabelLayout2.setVisibility(i);
            return;
          }
        }
        localLabelLayout2.setVisibility(8);
        return;
      }
      localLabelLayout1.setVisibility(8);
      return;
    }
    localLabelLayout1.setVisibility(8);
    localLabelLayout2.setVisibility(8);
  }
  
  public void onBackPressed()
  {
    destroy();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.mApp, "dc00898", "", "", "0X800AE98", "0X800AE98", 0, 0, "", "", "", "");
      destroy();
      dismiss();
      continue;
      destroy();
      dismiss();
      if (this.jdField_a_of_type_Afys$a != null)
      {
        this.jdField_a_of_type_Afys$a.ddw();
        continue;
        ddU();
        continue;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_Aftd.uin, 96);
        localAllInOne.subSourceId = 11;
        Intent localIntent = new Intent(getContext(), FriendProfileCardActivity.class);
        localIntent.putExtra("AllInOne", localAllInOne);
        localIntent.putExtra("key_from_extends_friend_limit_chat", true);
        localIntent.addFlags(536870912);
        getContext().startActivity(localIntent);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ddw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afys
 * JD-Core Version:    0.7.0.1
 */
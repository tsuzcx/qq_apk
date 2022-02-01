import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Observable;

public class zoo
  extends zof
{
  private ahme a;
  private boolean brZ;
  private RelativeLayout iE;
  private RelativeLayout iF;
  private View mDivider;
  
  public zoo(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private float aN()
  {
    Intent localIntent = ((Activity)this.mContext).getIntent();
    if (localIntent != null) {}
    for (float f = localIntent.getFloatExtra("minaio_scaled_ration", 0.78F);; f = 0.78F)
    {
      if (!zos.VB()) {
        f = 1.0F;
      }
      return f;
    }
  }
  
  private void cM(String paramString, int paramInt)
  {
    if (this.iE == null)
    {
      QLog.e(this.TAG, 2, "mGroupMemberView null");
      return;
    }
    if ((paramInt != 1) && (paramInt != 3000))
    {
      QLog.e(this.TAG, 2, "showGroupMemberDialog with wrong uin type");
      return;
    }
    anot.a(this.mApp, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 2, 0, "", "", "", "");
    QLog.i(this.TAG, 2, "showGroupMemberDialog");
    if (this.iF != null) {
      this.iF.setVisibility(4);
    }
    float f = aN();
    if (this.jdField_a_of_type_Ahme == null)
    {
      this.jdField_a_of_type_Ahme = new ahme(this.mContext);
      this.jdField_a_of_type_Ahme.a(this.mApp, paramString, paramInt, f);
      paramString = this.jdField_a_of_type_Ahme.getView();
      if (paramString != null) {
        this.iE.addView(paramString);
      }
    }
    this.brZ = true;
    if (this.cL != null) {
      this.cL.setBackgroundResource(2130840509);
    }
    if (this.iB != null) {
      this.iB.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840509));
    }
    this.iE.setVisibility(0);
  }
  
  private void cqE()
  {
    if (this.iE == null)
    {
      QLog.e(this.TAG, 2, "mGroupMemberView null");
      return;
    }
    QLog.i(this.TAG, 2, "hideGroupMemberDialog");
    this.brZ = false;
    if (this.cL != null) {
      this.cL.setBackgroundResource(2130840518);
    }
    if (this.iB != null) {
      this.iB.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840518));
    }
    if (this.iF != null) {
      this.iF.setVisibility(0);
    }
    this.iE.setVisibility(8);
  }
  
  protected void Ib()
  {
    this.TAG = "MiniPieForForward";
  }
  
  protected boolean Vz()
  {
    return true;
  }
  
  protected void aC()
  {
    super.aC();
    if (this.iC != null) {
      this.iC.setVisibility(0);
    }
    Object localObject;
    if (this.iB != null)
    {
      this.iF = ((RelativeLayout)this.iB.findViewById(2131377372));
      if ((this.uinType != 1) && (this.uinType != 3000)) {
        break label592;
      }
      if (this.iF != null)
      {
        this.iF.setVisibility(0);
        this.iF.setOnClickListener(this);
      }
      localObject = (ImageView)this.iB.findViewById(2131369594);
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(2130840514);
      }
    }
    for (;;)
    {
      this.iB.setBackgroundResource(2130840518);
      float f = aN();
      if (this.cL != null)
      {
        this.cL.setBackgroundResource(2130840518);
        this.mDivider = this.cL.findViewById(2131365990);
        if (this.mDivider != null) {
          this.mDivider.setVisibility(0);
        }
        this.iE = ((RelativeLayout)this.cL.findViewById(2131368186));
        localObject = (RelativeLayout)this.cL.findViewById(2131377361);
        if (localObject != null)
        {
          int i = this.mContext.getResources().getDimensionPixelSize(2131297368);
          if ((f > 0.0F) && (f <= 1.0F))
          {
            i = (int)(i / f);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
            if (localLayoutParams != null)
            {
              localLayoutParams.height = i;
              ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
            }
            i = (int)(16.0D / f);
            localObject = (TextView)this.cL.findViewById(2131379769);
            if (localObject != null)
            {
              ((TextView)localObject).setTextSize(2, i);
              ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
              localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
              localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
              ((TextView)localObject).setLayoutParams(localLayoutParams);
            }
            localObject = (RelativeLayout)this.cL.findViewById(2131369579);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                localLayoutParams.height = ((int)(localLayoutParams.height / f));
                localLayoutParams.width = ((int)(localLayoutParams.width / f));
                ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
              }
            }
            localObject = (ImageView)this.cL.findViewById(2131368962);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                localLayoutParams.height = ((int)(localLayoutParams.height / f));
                localLayoutParams.width = ((int)(localLayoutParams.width / f));
                localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
                ((ImageView)localObject).setLayoutParams(localLayoutParams);
              }
            }
            localObject = (ImageView)this.cL.findViewById(2131369594);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                i = wja.dp2px(18.0F, this.mContext.getResources());
                localLayoutParams.height = ((int)(i / f));
                localLayoutParams.width = ((int)(i / f));
                ((ImageView)localObject).setLayoutParams(localLayoutParams);
              }
            }
          }
        }
      }
      return;
      label592:
      if (this.iF != null) {
        this.iF.setVisibility(4);
      }
    }
  }
  
  public void aIH() {}
  
  protected void cqA()
  {
    ImageButton localImageButton = (ImageButton)this.cL.findViewById(2131362411);
    if (localImageButton != null) {
      localImageButton.setVisibility(8);
    }
  }
  
  protected void cqm() {}
  
  protected void cqq()
  {
    super.cqq();
    this.dG.setVisibility(8);
  }
  
  public void cqt()
  {
    if (this.brZ)
    {
      cqE();
      return;
    }
    QLog.i(this.TAG, 2, "doOnFinish");
    if (this.iE != null)
    {
      this.iE.removeAllViews();
      if (this.jdField_a_of_type_Ahme != null)
      {
        this.jdField_a_of_type_Ahme.destroy();
        this.jdField_a_of_type_Ahme = null;
      }
    }
    super.cqt();
    ((Activity)this.mContext).overridePendingTransition(0, 0);
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
      cM(this.uin, this.uinType);
      continue;
      cqt();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Znl.CS(19);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, getClass().getSimpleName() + " update");
    }
    if ((paramObject instanceof QQMessageFacade.b))
    {
      paramObservable = (QQMessageFacade.b)paramObject;
      paramObject = (wkk)paramObservable.context;
      if ((this.mSessionInfo.aTl != null) && (this.mSessionInfo.aTl.equals(paramObject.pf())))
      {
        if ((this.Fp != paramObject.em()) || (!paramObservable.aQk) || (!paramObservable.aQh)) {
          break label146;
        }
        l = this.Fp + 300L - SystemClock.uptimeMillis();
        if (l <= 0L) {
          break label141;
        }
        W(131076, l);
      }
    }
    label141:
    label146:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          long l = 0L;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "refreshMessageContext sync theSameUinAIO return");
      return;
    }
    QLog.d(this.TAG, 2, "update--> do nothing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoo
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;

public class zay
  extends yzr
{
  public zay(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.mApp.getManager(11);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof zay.a)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559078, paramViewGroup, false);
      paramViewGroup = new zay.a();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.xp = ((ImageView)paramView.findViewById(2131369830));
      paramViewGroup.l = ((SingleLineTextView)paramView.findViewById(2131379402));
      paramViewGroup.u = ((SingleLineTextView)paramView.findViewById(2131380833));
      paramViewGroup.uO = ((ImageView)paramView.findViewById(2131369920));
      paramViewGroup.er = ((Button)paramView.findViewById(2131377201));
      paramViewGroup.LF = ((TextView)paramView.findViewById(2131377211));
      paramView.setTag(paramViewGroup);
      fN(paramView.findViewById(2131368698));
      localPhoneContact = (PhoneContact)this.c;
      paramViewGroup.item = localPhoneContact;
      paramViewGroup.uin = localPhoneContact.mobileCode;
      paramInt1 = aqgv.aU(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
      paramInt2 = localPhoneContact.netTypeIconId;
      if ((paramInt1 != 0) && (paramInt1 != 6)) {
        break label522;
      }
      paramInt1 = 1;
      label225:
      if ((localPhoneContactManagerImp.KG & 0x8) != 8L)
      {
        paramOnClickListener = aH();
        ImageView localImageView = paramViewGroup.pQ;
        if (paramInt1 == 0) {
          break label527;
        }
        localImageView.setImageDrawable(paramOnClickListener);
      }
      label258:
      if (((paramInt1 == 0) || ((localPhoneContactManagerImp.KG & 0x8) == 8L)) && (!aqft.rj(localPhoneContact.uin))) {
        break label533;
      }
      paramViewGroup.xp.setImageDrawable(null);
      paramViewGroup.xp.setVisibility(8);
      label315:
      paramViewGroup.uO.setVisibility(8);
      paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
      paramViewGroup.l.setText(localPhoneContact.name);
      paramOnClickListener = (acff)this.mApp.getManager(51);
      if ((TextUtils.isEmpty(localPhoneContact.uin)) || (localPhoneContact.uin.equals("0"))) {
        break label609;
      }
      paramViewGroup.er.setVisibility(8);
      paramViewGroup.LF.setVisibility(0);
      paramViewGroup.LF.setText(acfp.m(2131703272));
      paramViewGroup.LF.setContentDescription(acfp.m(2131703275));
      label438:
      if (AppSetting.enableTalkBack)
      {
        paramViewGroup = paramViewGroup.H;
        if (paramViewGroup != null) {
          break label732;
        }
        paramViewGroup = new StringBuilder(24);
      }
    }
    for (;;)
    {
      paramViewGroup.append(localPhoneContact.name).append(".").append(null).append(".");
      paramViewGroup.append(aqgv.gf(paramInt2));
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup = (zay.a)paramView.getTag();
      break;
      label522:
      paramInt1 = 0;
      break label225;
      label527:
      paramOnClickListener = null;
      break label258;
      label533:
      paramOnClickListener = aqgv.E(localPhoneContact.netTypeIconId);
      if (paramOnClickListener != null)
      {
        paramOnClickListener.setBounds(0, 0, paramOnClickListener.getIntrinsicWidth(), paramOnClickListener.getIntrinsicHeight());
        paramViewGroup.xp.setImageDrawable(paramOnClickListener);
        paramViewGroup.xp.setVisibility(0);
        break label315;
      }
      paramViewGroup.xp.setImageDrawable(null);
      paramViewGroup.xp.setVisibility(8);
      break label315;
      label609:
      if (paramOnClickListener.w(localPhoneContact.unifiedCode, true))
      {
        paramViewGroup.er.setVisibility(8);
        paramViewGroup.LF.setVisibility(0);
        paramViewGroup.LF.setText(acfp.m(2131703274));
        paramViewGroup.LF.setContentDescription(acfp.m(2131703276));
        break label438;
      }
      paramViewGroup.er.setVisibility(0);
      paramViewGroup.er.setText(acfp.m(2131721053));
      paramViewGroup.er.setTag(localPhoneContact);
      paramViewGroup.er.setContentDescription(acfp.m(2131721053));
      paramViewGroup.LF.setVisibility(8);
      break label438;
      label732:
      paramViewGroup.delete(0, paramViewGroup.length());
    }
  }
  
  protected void fN(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
  
  public static class a
    extends yzr.b
  {
    public StringBuilder H;
    public TextView LF;
    public Button er;
    public SingleLineTextView u;
    public ImageView uO;
    
    a()
    {
      this.type = 11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity.i;
import com.tencent.mobileqq.data.PhoneContact;

public class aaxn
  extends TroopMemberListActivity.i
{
  public View Ag;
  public TextView OG;
  public TextView OH;
  public boolean bAI;
  public PhoneContact c;
  public CheckBox checkBox;
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new aaxn();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.hk = ((RelativeLayout)paramViewGroup.findViewById(2131377444));
    paramLayoutInflater.Gn = ((TextView)paramViewGroup.findViewById(2131380761));
    paramLayoutInflater.checkBox = ((CheckBox)paramViewGroup.findViewById(2131364587));
    paramLayoutInflater.pQ = ((ImageView)paramViewGroup.findViewById(2131368698));
    paramLayoutInflater.OG = ((TextView)paramViewGroup.findViewById(2131380753));
    paramLayoutInflater.OH = ((TextView)paramViewGroup.findViewById(2131380828));
    paramLayoutInflater.fe = ((TextView)paramViewGroup.findViewById(2131372190));
    paramLayoutInflater.Ag = paramViewGroup.findViewById(2131365942);
    return paramViewGroup;
  }
  
  public static void a(abdw paramabdw, aaxn paramaaxn, PhoneContact paramPhoneContact)
  {
    paramaaxn.hk.setVisibility(0);
    paramaaxn.Gn.setVisibility(8);
    paramaaxn.type = bX(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramaaxn.uin = ("pstn" + paramPhoneContact.mobileNo);
      paramaaxn.pQ.setImageResource(2130842937);
      paramaaxn.OG.setVisibility(0);
      paramaaxn.OG.setText(aqgv.ps(paramPhoneContact.name));
      paramaaxn.bAI = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramaaxn.uin = paramPhoneContact.uin;
      paramaaxn.pQ.setImageBitmap(paramabdw.a(paramaaxn.uin, 1, (byte)0));
      paramaaxn.OG.setVisibility(8);
      paramaaxn.bAI = false;
      return;
    }
    paramaaxn.uin = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramaaxn.pQ.setImageBitmap(paramabdw.a(paramaaxn.uin, 11, (byte)0));
    paramaaxn.OG.setVisibility(8);
    paramaaxn.bAI = false;
  }
  
  public static int bX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("0".equals(paramString)) {
      return 11;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxn
 * JD-Core Version:    0.7.0.1
 */
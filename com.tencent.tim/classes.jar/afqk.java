import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afqk
  implements View.OnClickListener
{
  afqk(afqj paramafqj, afns paramafns) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    String str1;
    label41:
    String str3;
    if (this.jdField_a_of_type_Afns.bZQ)
    {
      localIntent.putExtra("emoji_to_dressup", true);
      if (this.jdField_a_of_type_Afqj.app != null) {
        break label221;
      }
      str1 = "";
      str3 = this.jdField_a_of_type_Afqj.d.epId;
      if (!this.jdField_a_of_type_Afns.bZQ) {
        break label235;
      }
    }
    label221:
    label235:
    for (String str2 = "1";; str2 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "0X8007192", null, 1, 0, 0, null, str3, str2);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_Afqj.mContext, this.jdField_a_of_type_Afqj.app.getAccount(), 8, String.valueOf(this.jdField_a_of_type_Afqj.d.epId), false, localIntent, true);
      anot.a(this.jdField_a_of_type_Afqj.app, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.jdField_a_of_type_Afqj.d.epId, "2", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Afqj.d.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("emoji_is_original", bool);
        localIntent.putExtra("emoji_author_id", this.jdField_a_of_type_Afns.cSF);
        break;
      }
      str1 = this.jdField_a_of_type_Afqj.app.getCurrentAccountUin();
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqk
 * JD-Core Version:    0.7.0.1
 */
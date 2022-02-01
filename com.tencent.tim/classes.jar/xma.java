import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.NewIntent;

class xma
  implements View.OnClickListener
{
  boolean like = this.bhI;
  int num = this.val$likeNum;
  
  xma(xlx paramxlx, boolean paramBoolean, int paramInt1, xlx.a parama, String paramString, int paramInt2, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    boolean bool;
    label53:
    int i;
    label72:
    Object localObject2;
    if (!this.like)
    {
      bool = true;
      this.like = bool;
      if (!this.like) {
        break label332;
      }
      this.num += 1;
      this.jdField_a_of_type_Xlx$a.JG.setText(xlx.access$000(this.num));
      localObject1 = this.jdField_a_of_type_Xlx$a.dp;
      if (!this.like) {
        break label363;
      }
      i = 2130848389;
      ((ImageView)localObject1).setImageResource(i);
      long l = this.jdField_a_of_type_Xlx.app.getLongAccountUin();
      localObject1 = this.aVD;
      localObject2 = this.aVD;
      i = j;
      if (this.like) {
        i = 0;
      }
      localObject1 = new avtt(Long.valueOf(l), (String)localObject1, (String)localObject2, i, this.Og);
      ((avtt)localObject1).setType(100);
      localObject2 = new QzoneCommonIntent(this.jdField_a_of_type_Xlx.app.getApplication(), afaf.class);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("like_key", this.like);
      ((QzoneCommonIntent)localObject2).putExtras(localBundle);
      ((QzoneCommonIntent)localObject2).setRequest((avpr)localObject1);
      this.jdField_a_of_type_Xlx.app.startServlet((NewIntent)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.ulikeNum = this.num;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt = new HashMap();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.mapExt;
      if (!this.like) {
        break label369;
      }
    }
    label332:
    label363:
    label369:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ((HashMap)localObject2).put("isliked", localObject1);
      this.jdField_a_of_type_Xlx.app.b().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, false);
      this.jdField_a_of_type_Xlx.app.b().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.selfuin);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      this.num -= 1;
      this.jdField_a_of_type_Xlx$a.JG.setText(xlx.access$000(this.num));
      break label53;
      i = 2130848388;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xma
 * JD-Core Version:    0.7.0.1
 */
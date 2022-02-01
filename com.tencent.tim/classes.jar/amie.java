import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;

public class amie
  extends amib
{
  public CheckBox Q;
  QQAppInterface app;
  public CommentsView b;
  public LikesView b;
  public int index;
  public RichStatus richStatus;
  
  public amie(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.app = ((QQAppInterface)paramAppInterface);
    this.type = 1;
  }
  
  protected int IK()
  {
    return mZ[12];
  }
  
  protected void Pj(boolean paramBoolean)
  {
    super.Pj(paramBoolean);
    int i;
    label49:
    label77:
    label98:
    LikesView localLikesView;
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView != null)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView;
      if (paramBoolean)
      {
        i = mZ[14];
        ((CommentsView)localObject).setNormalTextColor(i);
        localObject = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView;
        if (!paramBoolean) {
          break label162;
        }
        i = mZ[13];
        ((CommentsView)localObject).setItemColor(i);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView != null)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
      if (!paramBoolean) {
        break label172;
      }
      i = mZ[14];
      ((LikesView)localObject).setNormalTextColor(i);
      localObject = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
      if (!paramBoolean) {
        break label182;
      }
      i = mZ[13];
      ((LikesView)localObject).setItemColor(i);
      localObject = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.aO();
      if ((this.context != null) && (localObject != null))
      {
        localLikesView = this.jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
        if (!paramBoolean) {
          break label192;
        }
      }
    }
    label162:
    label172:
    label182:
    label192:
    for (Object localObject = this.context.getResources().getDrawable(2130848312);; localObject = this.context.getResources().getDrawable(2130848313))
    {
      localLikesView.setLikSpanDrawable((Drawable)localObject);
      return;
      i = mZ[16];
      break;
      i = mZ[15];
      break label49;
      i = mZ[15];
      break label77;
      i = mZ[15];
      break label98;
    }
  }
  
  public View a(RichStatus paramRichStatus)
  {
    return super.a(paramRichStatus);
  }
  
  protected boolean avU()
  {
    return true;
  }
  
  protected boolean avV()
  {
    return false;
  }
  
  protected void dND() {}
  
  protected void initViews()
  {
    super.initViews();
    this.kj.setMinimumHeight(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amie
 * JD-Core Version:    0.7.0.1
 */
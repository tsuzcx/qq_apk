import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class xue
  extends xsr
{
  private String jdField_a_of_type_JavaLangString;
  private xne jdField_a_of_type_Xne;
  private String b = "";
  private boolean c;
  
  private wra a(StoryVideoItem paramStoryVideoItem)
  {
    wrb localwrb = paramStoryVideoItem.getOALinkInfo();
    if ((localwrb != null) && (localwrb.a != null))
    {
      yqp.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    yqp.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<xli> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xuf(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Xne != null) && (this.jdField_a_of_type_Xne.a().isGameVideo())) {
      yqu.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xne.a().mVid });
    }
    return true;
  }
  
  public void b(xss paramxss, xne paramxne)
  {
    this.jdField_a_of_type_Xne = paramxne;
    Object localObject2 = paramxne.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Xso.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((wqz)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramxss.c.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839606);
    paramxss.jdField_a_of_type_AndroidViewView.setPadding(paramxss.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramxss.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramxss.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramxss.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((wpy)wpm.a(2)).b(paramxne.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((wra)localObject1).d;
      localObject2 = ((wra)localObject1).e;
      localObject1 = ((wra)localObject1).f;
      localObject3 = paramxss.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      xso.a(str, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramxne.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Xne != null)) {
        yqu.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xne.a().mVid });
      }
      return;
      str = ((wra)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((wra)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((wra)localObject1).c;
        break;
      }
      localObject1 = anni.a(2131703805);
      break;
      label339:
      localObject1 = anni.a(2131703804);
      break label176;
      label348:
      this.c = true;
      if (!bncl.a(this.jdField_a_of_type_Xso.b())) {
        bncl.a(this.jdField_a_of_type_Xso.b());
      }
      this.b = paramxne.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xue
 * JD-Core Version:    0.7.0.1
 */
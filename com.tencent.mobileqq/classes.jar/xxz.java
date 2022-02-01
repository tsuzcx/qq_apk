import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class xxz
  extends xwm
{
  private String jdField_a_of_type_JavaLangString;
  private xqz jdField_a_of_type_Xqz;
  private String b = "";
  private boolean c;
  
  private wuv a(StoryVideoItem paramStoryVideoItem)
  {
    wuw localwuw = paramStoryVideoItem.getOALinkInfo();
    if ((localwuw != null) && (localwuw.a != null))
    {
      yuk.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    yuk.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<xpd> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xya(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Xqz != null) && (this.jdField_a_of_type_Xqz.a().isGameVideo())) {
      yup.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xqz.a().mVid });
    }
    return true;
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    this.jdField_a_of_type_Xqz = paramxqz;
    Object localObject2 = paramxqz.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Xwj.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((wuu)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramxwn.c.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839615);
    paramxwn.jdField_a_of_type_AndroidViewView.setPadding(paramxwn.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramxwn.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramxwn.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramxwn.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((wtt)wth.a(2)).b(paramxqz.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((wuv)localObject1).d;
      localObject2 = ((wuv)localObject1).e;
      localObject1 = ((wuv)localObject1).f;
      localObject3 = paramxwn.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      xwj.a(str, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramxqz.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Xqz != null)) {
        yup.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xqz.a().mVid });
      }
      return;
      str = ((wuv)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((wuv)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((wuv)localObject1).c;
        break;
      }
      localObject1 = anzj.a(2131703912);
      break;
      label339:
      localObject1 = anzj.a(2131703911);
      break label176;
      label348:
      this.c = true;
      if (!bodt.a(this.jdField_a_of_type_Xwj.b())) {
        bodt.a(this.jdField_a_of_type_Xwj.b());
      }
      this.b = paramxqz.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxz
 * JD-Core Version:    0.7.0.1
 */
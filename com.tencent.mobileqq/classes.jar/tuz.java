import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class tuz
  extends ttm
{
  private String jdField_a_of_type_JavaLangString;
  private tnz jdField_a_of_type_Tnz;
  private String b = "";
  private boolean c;
  
  private sru a(StoryVideoItem paramStoryVideoItem)
  {
    srv localsrv = paramStoryVideoItem.getOALinkInfo();
    if ((localsrv != null) && (localsrv.a != null))
    {
      urk.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    urk.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<tmd> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new tva(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Tnz != null) && (this.jdField_a_of_type_Tnz.a().isGameVideo())) {
      urp.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tnz.a().mVid });
    }
    return true;
  }
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    this.jdField_a_of_type_Tnz = paramtnz;
    Object localObject2 = paramtnz.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Ttj.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((srt)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramttn.c.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839325);
    paramttn.jdField_a_of_type_AndroidViewView.setPadding(paramttn.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramttn.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramttn.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramttn.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((sqs)sqg.a(2)).b(paramtnz.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((sru)localObject1).d;
      localObject2 = ((sru)localObject1).e;
      localObject1 = ((sru)localObject1).f;
      localObject3 = paramttn.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ttj.a(str, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramtnz.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Tnz != null)) {
        urp.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tnz.a().mVid });
      }
      return;
      str = ((sru)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((sru)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((sru)localObject1).c;
        break;
      }
      localObject1 = ajjy.a(2131639229);
      break;
      label339:
      localObject1 = ajjy.a(2131639228);
      break label176;
      label348:
      this.c = true;
      if (!bheo.a(this.jdField_a_of_type_Ttj.b())) {
        bheo.a(this.jdField_a_of_type_Ttj.b());
      }
      this.b = paramtnz.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuz
 * JD-Core Version:    0.7.0.1
 */
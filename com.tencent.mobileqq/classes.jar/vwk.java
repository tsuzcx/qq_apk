import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class vwk
  extends vux
{
  private String jdField_a_of_type_JavaLangString;
  private vpk jdField_a_of_type_Vpk;
  private String b = "";
  private boolean c;
  
  private utf a(StoryVideoItem paramStoryVideoItem)
  {
    utg localutg = paramStoryVideoItem.getOALinkInfo();
    if ((localutg != null) && (localutg.a != null))
    {
      wsv.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    wsv.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<vno> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new vwl(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Vpk != null) && (this.jdField_a_of_type_Vpk.a().isGameVideo())) {
      wta.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpk.a().mVid });
    }
    return true;
  }
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    this.jdField_a_of_type_Vpk = paramvpk;
    Object localObject2 = paramvpk.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Vuu.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((ute)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramvuy.c.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839430);
    paramvuy.jdField_a_of_type_AndroidViewView.setPadding(paramvuy.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramvuy.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramvuy.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramvuy.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((usd)urr.a(2)).b(paramvpk.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((utf)localObject1).d;
      localObject2 = ((utf)localObject1).e;
      localObject1 = ((utf)localObject1).f;
      localObject3 = paramvuy.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      vuu.a(str, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramvpk.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Vpk != null)) {
        wta.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpk.a().mVid });
      }
      return;
      str = ((utf)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((utf)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((utf)localObject1).c;
        break;
      }
      localObject1 = alpo.a(2131705397);
      break;
      label339:
      localObject1 = alpo.a(2131705396);
      break label176;
      label348:
      this.c = true;
      if (!bkjr.a(this.jdField_a_of_type_Vuu.b())) {
        bkjr.a(this.jdField_a_of_type_Vuu.b());
      }
      this.b = paramvpk.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class xxj
  extends xwm
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private wuw jdField_a_of_type_Wuw;
  private xqz jdField_a_of_type_Xqz;
  private xwp jdField_a_of_type_Xwp;
  private xxm jdField_a_of_type_Xxm;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Xwj);
      if (this.jdField_a_of_type_Xwp != null) {
        this.jdField_a_of_type_Xwp.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Xxm != null) {
        this.jdField_a_of_type_Xxm.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher.a(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {}
    StoryVideoItem localStoryVideoItem;
    int i;
    label190:
    do
    {
      return;
      localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
      Object localObject2 = this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut;
      i = this.jdField_a_of_type_Xqz.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((wut)localObject2).jdField_a_of_type_JavaLangString;
        str = ((wut)localObject2).b;
        int j = ((wut)localObject2).jdField_a_of_type_Int;
        localObject2 = (wte)wth.a(5);
        wtt localwtt = (wtt)wth.a(2);
        localObject2 = ((wte)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localwtt.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            yup.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
            return;
            i = 0;
            break;
          }
        }
        this.b = str;
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    String str = localStoryVideoItem.mVid;
    a(str, "", true, i, 0);
    Object localObject1 = ((wtt)wth.a(2)).b(localStoryVideoItem.mOwnerUid);
    if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
    {
      i = 1;
      if (i == 0) {
        break label311;
      }
    }
    label311:
    for (localObject1 = "2";; localObject1 = "1")
    {
      yup.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Xxm == null) {
      this.jdField_a_of_type_Xxm = new xxm(this);
    }
    localHashMap.put(this.jdField_a_of_type_Xxm, "");
    localHashMap.put(new xxl(this), "");
    localHashMap.put(new xxk(this), "");
    return localHashMap;
  }
  
  public Set<xpd> a()
  {
    HashSet localHashSet = new HashSet(1);
    xwp localxwp = new xwp();
    this.jdField_a_of_type_Xwp = localxwp;
    localHashSet.add(localxwp);
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    b();
    return true;
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    this.jdField_a_of_type_Xqz = paramxqz;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramxqz.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    wuw localwuw = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((wuw)localObject).jdField_a_of_type_Wut != null) && (!TextUtils.isEmpty(((wuw)localObject).jdField_a_of_type_Wut.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Wuw = ((wuw)localObject);
      yuk.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramxqz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wuw.b, this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut.b, Integer.valueOf(this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut.jdField_a_of_type_Int), this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Xwj.j();
      localObject = this.jdField_a_of_type_Wuw.jdField_a_of_type_Wut;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxqz.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxwn.b.setVisibility(0);
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxqz = this.jdField_a_of_type_Wuw.b;
      if (TextUtils.isEmpty(paramxqz)) {
        break label503;
      }
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(paramxqz);
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramxqz);
      paramxwn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846436);
      if ((localObject != null) && (!TextUtils.isEmpty(((wut)localObject).jdField_c_of_type_JavaLangString))) {
        xwj.a(((wut)localObject).jdField_c_of_type_JavaLangString, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130846436), paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
      }
      paramxwn = ((wtt)wth.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramxwn == null) || (!paramxwn.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((wut)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramxwn = "2";
        label362:
        if (localObject == null) {
          break label549;
        }
      }
    }
    label532:
    label537:
    label543:
    label549:
    for (paramxqz = ((wut)localObject).b;; paramxqz = "")
    {
      yup.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramxwn, paramxqz, "", localStoryVideoItem.mVid });
      return;
      if ((localwuw != null) && (localwuw.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Wuw = localwuw;
        yuk.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramxqz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wuw.b);
        break;
      }
      yuk.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramxqz.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Xwj.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Wuw = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramxqz.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700353));
      paramxwn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131700354));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramxwn = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxj
 * JD-Core Version:    0.7.0.1
 */
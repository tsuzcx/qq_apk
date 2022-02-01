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

public class xto
  extends xsr
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private wrb jdField_a_of_type_Wrb;
  private xne jdField_a_of_type_Xne;
  private xsu jdField_a_of_type_Xsu;
  private xtr jdField_a_of_type_Xtr;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Xso);
      if (this.jdField_a_of_type_Xsu != null) {
        this.jdField_a_of_type_Xsu.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Xtr != null) {
        this.jdField_a_of_type_Xtr.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
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
      localStoryVideoItem = this.jdField_a_of_type_Xne.a();
      Object localObject2 = this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy;
      i = this.jdField_a_of_type_Xne.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((wqy)localObject2).jdField_a_of_type_JavaLangString;
        str = ((wqy)localObject2).b;
        int j = ((wqy)localObject2).jdField_a_of_type_Int;
        localObject2 = (wpj)wpm.a(5);
        wpy localwpy = (wpy)wpm.a(2);
        localObject2 = ((wpj)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localwpy.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            yqu.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((wpy)wpm.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      yqu.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Xtr == null) {
      this.jdField_a_of_type_Xtr = new xtr(this);
    }
    localHashMap.put(this.jdField_a_of_type_Xtr, "");
    localHashMap.put(new xtq(this), "");
    localHashMap.put(new xtp(this), "");
    return localHashMap;
  }
  
  public Set<xli> a()
  {
    HashSet localHashSet = new HashSet(1);
    xsu localxsu = new xsu();
    this.jdField_a_of_type_Xsu = localxsu;
    localHashSet.add(localxsu);
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
  
  public void b(xss paramxss, xne paramxne)
  {
    this.jdField_a_of_type_Xne = paramxne;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramxne.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    wrb localwrb = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((wrb)localObject).jdField_a_of_type_Wqy != null) && (!TextUtils.isEmpty(((wrb)localObject).jdField_a_of_type_Wqy.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Wrb = ((wrb)localObject);
      yqp.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramxne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wrb.b, this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy.b, Integer.valueOf(this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy.jdField_a_of_type_Int), this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Xso.j();
      localObject = this.jdField_a_of_type_Wrb.jdField_a_of_type_Wqy;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxne.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxss.b.setVisibility(0);
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxne = this.jdField_a_of_type_Wrb.b;
      if (TextUtils.isEmpty(paramxne)) {
        break label503;
      }
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(paramxne);
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramxne);
      paramxss.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846419);
      if ((localObject != null) && (!TextUtils.isEmpty(((wqy)localObject).jdField_c_of_type_JavaLangString))) {
        xso.a(((wqy)localObject).jdField_c_of_type_JavaLangString, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130846419), paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
      }
      paramxss = ((wpy)wpm.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramxss == null) || (!paramxss.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((wqy)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramxss = "2";
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
    for (paramxne = ((wqy)localObject).b;; paramxne = "")
    {
      yqu.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramxss, paramxne, "", localStoryVideoItem.mVid });
      return;
      if ((localwrb != null) && (localwrb.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Wrb = localwrb;
        yqp.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramxne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wrb.b);
        break;
      }
      yqp.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramxne.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Xso.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Wrb = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramxne.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131700246));
      paramxss.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131700247));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramxss = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xto
 * JD-Core Version:    0.7.0.1
 */
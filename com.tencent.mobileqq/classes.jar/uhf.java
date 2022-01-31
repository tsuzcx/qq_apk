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

public class uhf
  extends ugi
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private ter jdField_a_of_type_Ter;
  private uav jdField_a_of_type_Uav;
  private ugl jdField_a_of_type_Ugl;
  private uhi jdField_a_of_type_Uhi;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Ugf);
      if (this.jdField_a_of_type_Ugl != null) {
        this.jdField_a_of_type_Ugl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Uhi != null) {
        this.jdField_a_of_type_Uhi.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
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
      localStoryVideoItem = this.jdField_a_of_type_Uav.a();
      Object localObject2 = this.jdField_a_of_type_Ter.jdField_a_of_type_Teo;
      i = this.jdField_a_of_type_Uav.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((teo)localObject2).jdField_a_of_type_JavaLangString;
        str = ((teo)localObject2).b;
        int j = ((teo)localObject2).jdField_a_of_type_Int;
        localObject2 = (tcz)tdc.a(5);
        tdo localtdo = (tdo)tdc.a(2);
        localObject2 = ((tcz)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localtdo.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            vel.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((tdo)tdc.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      vel.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Uhi == null) {
      this.jdField_a_of_type_Uhi = new uhi(this);
    }
    localHashMap.put(this.jdField_a_of_type_Uhi, "");
    localHashMap.put(new uhh(this), "");
    localHashMap.put(new uhg(this), "");
    return localHashMap;
  }
  
  public Set<tyz> a()
  {
    HashSet localHashSet = new HashSet(1);
    ugl localugl = new ugl();
    this.jdField_a_of_type_Ugl = localugl;
    localHashSet.add(localugl);
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
  
  public void b(ugj paramugj, uav paramuav)
  {
    this.jdField_a_of_type_Uav = paramuav;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramuav.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    ter localter = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((ter)localObject).jdField_a_of_type_Teo != null) && (!TextUtils.isEmpty(((ter)localObject).jdField_a_of_type_Teo.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Ter = ((ter)localObject);
      veg.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramuav.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ter.b, this.jdField_a_of_type_Ter.jdField_a_of_type_Teo.b, Integer.valueOf(this.jdField_a_of_type_Ter.jdField_a_of_type_Teo.jdField_a_of_type_Int), this.jdField_a_of_type_Ter.jdField_a_of_type_Teo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ter.jdField_a_of_type_Teo.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Ugf.j();
      localObject = this.jdField_a_of_type_Ter.jdField_a_of_type_Teo;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuav.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramugj.b.setVisibility(0);
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramuav = this.jdField_a_of_type_Ter.b;
      if (TextUtils.isEmpty(paramuav)) {
        break label503;
      }
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(paramuav);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramuav);
      paramugj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845522);
      if ((localObject != null) && (!TextUtils.isEmpty(((teo)localObject).jdField_c_of_type_JavaLangString))) {
        ugf.a(((teo)localObject).jdField_c_of_type_JavaLangString, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130845522), paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
      }
      paramugj = ((tdo)tdc.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramugj == null) || (!paramugj.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((teo)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramugj = "2";
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
    for (paramuav = ((teo)localObject).b;; paramuav = "")
    {
      vel.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramugj, paramuav, "", localStoryVideoItem.mVid });
      return;
      if ((localter != null) && (localter.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Ter = localter;
        veg.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramuav.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ter.b);
        break;
      }
      veg.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramuav.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ugf.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Ter = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramuav.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701430));
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajyc.a(2131701431));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramugj = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */
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

public class vvu
  extends vux
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private utg jdField_a_of_type_Utg;
  private vpk jdField_a_of_type_Vpk;
  private vva jdField_a_of_type_Vva;
  private vvx jdField_a_of_type_Vvx;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Vuu);
      if (this.jdField_a_of_type_Vva != null) {
        this.jdField_a_of_type_Vva.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Vvx != null) {
        this.jdField_a_of_type_Vvx.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
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
      localStoryVideoItem = this.jdField_a_of_type_Vpk.a();
      Object localObject2 = this.jdField_a_of_type_Utg.jdField_a_of_type_Utd;
      i = this.jdField_a_of_type_Vpk.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((utd)localObject2).jdField_a_of_type_JavaLangString;
        str = ((utd)localObject2).b;
        int j = ((utd)localObject2).jdField_a_of_type_Int;
        localObject2 = (uro)urr.a(5);
        usd localusd = (usd)urr.a(2);
        localObject2 = ((uro)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localusd.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            wta.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((usd)urr.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      wta.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Vvx == null) {
      this.jdField_a_of_type_Vvx = new vvx(this);
    }
    localHashMap.put(this.jdField_a_of_type_Vvx, "");
    localHashMap.put(new vvw(this), "");
    localHashMap.put(new vvv(this), "");
    return localHashMap;
  }
  
  public Set<vno> a()
  {
    HashSet localHashSet = new HashSet(1);
    vva localvva = new vva();
    this.jdField_a_of_type_Vva = localvva;
    localHashSet.add(localvva);
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
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    this.jdField_a_of_type_Vpk = paramvpk;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramvpk.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    utg localutg = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((utg)localObject).jdField_a_of_type_Utd != null) && (!TextUtils.isEmpty(((utg)localObject).jdField_a_of_type_Utd.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Utg = ((utg)localObject);
      wsv.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramvpk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Utg.b, this.jdField_a_of_type_Utg.jdField_a_of_type_Utd.b, Integer.valueOf(this.jdField_a_of_type_Utg.jdField_a_of_type_Utd.jdField_a_of_type_Int), this.jdField_a_of_type_Utg.jdField_a_of_type_Utd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Utg.jdField_a_of_type_Utd.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Vuu.j();
      localObject = this.jdField_a_of_type_Utg.jdField_a_of_type_Utd;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvpk.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramvuy.b.setVisibility(0);
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramvpk = this.jdField_a_of_type_Utg.b;
      if (TextUtils.isEmpty(paramvpk)) {
        break label503;
      }
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(paramvpk);
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramvpk);
      paramvuy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845907);
      if ((localObject != null) && (!TextUtils.isEmpty(((utd)localObject).jdField_c_of_type_JavaLangString))) {
        vuu.a(((utd)localObject).jdField_c_of_type_JavaLangString, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130845907), paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
      }
      paramvuy = ((usd)urr.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramvuy == null) || (!paramvuy.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((utd)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramvuy = "2";
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
    for (paramvpk = ((utd)localObject).b;; paramvpk = "")
    {
      wta.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramvuy, paramvpk, "", localStoryVideoItem.mVid });
      return;
      if ((localutg != null) && (localutg.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Utg = localutg;
        wsv.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramvpk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Utg.b);
        break;
      }
      wsv.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramvpk.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Vuu.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Utg = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramvpk.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701814));
      paramvuy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131701815));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramvuy = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvu
 * JD-Core Version:    0.7.0.1
 */
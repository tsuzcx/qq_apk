import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;

public class wak
  implements View.OnClickListener, bhpo, bhum, wbl
{
  private final long jdField_a_of_type_Long = 500L;
  private final QQStoryShareGroupProfileActivity jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity;
  private long b;
  
  public wak(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity = paramQQStoryShareGroupProfileActivity;
  }
  
  private void a(View paramView, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b;
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.a;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < ((List)localObject).size())
    {
      HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)((List)localObject).get(i);
      localArrayList1.add(localHotSortVideoEntry.feedId);
      localArrayList2.add(localHotSortVideoEntry.storyId);
      if (paramString.equals(localHotSortVideoEntry.storyId)) {
        j = i;
      }
      i += 1;
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(localArrayList1, localArrayList2, (String)localArrayList1.get(j), (String)localArrayList2.get(j)), 88);
      vju.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, ((OpenPlayerBuilder)localObject).a(), paramView);
    }
    wta.a("share_story", "clk_video_card", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b, paramString });
  }
  
  public void a()
  {
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, "2", 1003);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Wap != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Wap.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, View paramView, String paramString2)
  {
    if (System.currentTimeMillis() - this.b < 500L) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.g)
      {
        a(paramView, paramString2);
        return;
      }
      String str = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b;
      ure localure = (ure)urr.a(19);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = localure.a(str, localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0))
      {
        paramInt = localArrayList2.indexOf(paramString1);
        paramString1 = localure.a(str);
        if ((paramString1 != null) && (paramString1.isEnd == 1)) {}
        for (boolean bool = true; this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c == 1; bool = false)
        {
          paramString1 = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(str, (String)localArrayList1.get(paramInt), paramString2, String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Wap.hashCode()), localArrayList2, bool, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a());
          paramString1.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a());
          vju.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, paramString1.a(), paramView);
          return;
        }
      }
    }
  }
  
  public void a(String paramString1, long paramLong, StoryVideoItem paramStoryVideoItem, int paramInt, String paramString2, List<String> paramList)
  {
    if (xod.b()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Vdt == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Vdt = vdt.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Vdt.a(alpo.a(2131711421) + ugx.a + alpo.a(2131711393)).a(vew.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramStoryVideoItem, paramString1, paramLong, paramInt)).a(new wal(this)).b();
    wta.a("share_story", "share_day", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
  
  public boolean a(String paramString)
  {
    VideoCollectionItem localVideoCollectionItem = ((ure)urr.a(19)).a(paramString);
    if (localVideoCollectionItem != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a(localVideoCollectionItem);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onLoadMore: videoCollectionItem is null, collectionId:" + paramString);
    }
    return false;
  }
  
  public void b()
  {
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, true);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b(false);
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "QQStoryShareGroupProfileActivity onHeaderItemClick!");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.g) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Wap == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Wap.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.a());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131373778: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, "5", 1004);
      return;
    case 2131368613: 
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.finish();
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_Xob.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wak
 * JD-Core Version:    0.7.0.1
 */
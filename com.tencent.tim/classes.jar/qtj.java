import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Arrays;

public class qtj
  implements ausj.a
{
  public qtj(StoryMemoriesFragment paramStoryMemoriesFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    this.val$actionSheet.superDismiss();
    paramInt = StoryMemoriesFragment.a(this.this$0, this.val$actionSheet.getContent(paramInt));
    int j = StoryMemoriesFragment.dX(StoryMemoriesFragment.a(this.this$0).mFrom);
    String str1;
    label79:
    String str2;
    if (StoryMemoriesFragment.a(this.this$0).mUserUIItem.isMe())
    {
      paramView = "1";
      if (!StoryMemoriesFragment.a(this.this$0).mUserUIItem.isVip()) {
        break label231;
      }
      str1 = "1";
      if ((!StoryMemoriesFragment.a(this.this$0).mUserUIItem.isFriend()) && (!StoryMemoriesFragment.a(this.this$0).mUserUIItem.isMe())) {
        break label238;
      }
      str2 = "1";
      label115:
      rar.a("memory", "clk_more_one", j, 0, new String[] { paramView, str1, str2, StoryMemoriesFragment.a(paramInt, StoryMemoriesFragment.a(this.this$0).mUserUIItem.isMe(), StoryMemoriesFragment.a(this.this$0).mUserUIItem.isSubscribe()) });
      switch (paramInt)
      {
      }
    }
    label231:
    label238:
    do
    {
      return;
      paramView = "2";
      break;
      str1 = "2";
      break label79;
      str2 = "2";
      break label115;
      StoryMemoriesFragment.a(this.this$0);
      return;
      this.this$0.d(StoryMemoriesFragment.a(this.this$0).mUserUIItem);
      return;
      if (StoryMemoriesFragment.a(this.this$0).mUserUIItem.isSubscribe())
      {
        paramInt = 1;
        paramView = (pma)qem.getQQAppInterface().getBusinessHandler(98);
        if (!StoryMemoriesFragment.a(this.this$0).mUserUIItem.isVip()) {
          break label340;
        }
      }
      for (;;)
      {
        paramView.b(i, StoryMemoriesFragment.a(this.this$0).mUid, paramInt, 2);
        return;
        paramInt = 0;
        break;
        i = 0;
      }
      qem.a(this.this$0.getActivity(), StoryMemoriesFragment.a(this.this$0).mUserUIItem, new qtk(this));
      return;
      if (StoryMemoriesFragment.a(this.this$0).mUserUIItem.isMe())
      {
        StoryMemoriesFragment.b(this.this$0);
        return;
      }
      StoryMemoriesFragment.c(this.this$0);
      return;
    } while (rpq.isFastDoubleClick());
    label340:
    if (StoryMemoriesFragment.a(this.this$0) == null) {
      StoryMemoriesFragment.a(this.this$0, qbc.a(this.this$0.getActivity()));
    }
    StoryMemoriesFragment.a(this.this$0).a(Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } }));
    StoryMemoriesFragment.a(this.this$0).a(2131720177).a(new qcd(StoryMemoriesFragment.a(this.this$0).mUserUIItem)).a(new qtl(this)).b();
    rar.a("memory", "clk_share", StoryMemoriesFragment.dX(StoryMemoriesFragment.a(this.this$0).mFrom), 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtj
 * JD-Core Version:    0.7.0.1
 */
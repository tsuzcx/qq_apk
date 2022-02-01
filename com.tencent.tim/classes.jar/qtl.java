import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;

class qtl
  extends qbi
{
  qtl(qtj paramqtj) {}
  
  public void onFinish()
  {
    super.onFinish();
    StoryMemoriesFragment.a(this.a.this$0, null);
  }
  
  public void onSuccess(int paramInt)
  {
    super.onSuccess(paramInt);
    boolean bool = QQStoryContext.a().eV(StoryMemoriesFragment.a(this.a.this$0).mUserUIItem.qq);
    int i;
    int j;
    String str1;
    if (StoryMemoriesFragment.a(this.a.this$0).mUserUIItem.isVip)
    {
      i = 1;
      j = StoryMemoriesFragment.dX(StoryMemoriesFragment.a(this.a.this$0).mFrom);
      if (!bool) {
        break label124;
      }
      str1 = "1";
      label76:
      if (i != 1) {
        break label131;
      }
    }
    label131:
    for (String str2 = "1";; str2 = "2")
    {
      rar.a("memory", "share_suc", j, paramInt, new String[] { str1, str2, "", "" });
      return;
      i = 0;
      break;
      label124:
      str1 = "2";
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtl
 * JD-Core Version:    0.7.0.1
 */
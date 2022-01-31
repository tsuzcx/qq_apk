import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;

class usr
  extends tpk
{
  usr(usp paramusp) {}
  
  public void a()
  {
    super.a();
    StoryMemoriesFragment.a(this.a.a, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    boolean bool = QQStoryContext.a().b(StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq);
    int i;
    int j;
    String str1;
    if (StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip)
    {
      i = 1;
      j = StoryMemoriesFragment.a(StoryMemoriesFragment.a(this.a.a).jdField_a_of_type_Int);
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
      vel.a("memory", "share_suc", j, paramInt, new String[] { str1, str2, "", "" });
      return;
      i = 0;
      break;
      label124:
      str1 = "2";
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */
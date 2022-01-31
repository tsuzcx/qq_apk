import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.json.JSONArray;

public class ukh
  extends uxs
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      ved.d("AddVideoMiddleCode", "unknown request code %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramInt2, paramIntent);
      e();
      return;
    }
    if (paramInt2 == -1) {}
    for (;;)
    {
      try
      {
        LinkedHashSet localLinkedHashSet = (LinkedHashSet)paramIntent.getSerializableExtra("extra_checked_vidset");
        if ((localLinkedHashSet != null) && (localLinkedHashSet.size() > 0))
        {
          ved.d("AddVideoMiddleCode", "let's add video to group, count = %d, collection = %s", new Object[] { Integer.valueOf(localLinkedHashSet.size()), new JSONArray(localLinkedHashSet).toString() });
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(localLinkedHashSet);
          svl.a(this.jdField_a_of_type_JavaLangString, localArrayList, this.jdField_a_of_type_Int);
          paramIntent.putExtra("totalPublishVideoCount", localLinkedHashSet.size());
          paramIntent.putExtra("isAddFromExist", true);
          a(paramInt2, paramIntent);
          e();
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        ved.c("AddVideoMiddleCode", "StoryPickerFragment return illegal value", localClassCastException);
        Object localObject = null;
        continue;
        ved.d("AddVideoMiddleCode", "do not add video to group, exit ! result=%s, retValue=%s", new Object[] { Integer.valueOf(paramInt2), localObject });
        paramInt2 = 0;
        continue;
      }
      ved.d("AddVideoMiddleCode", "add video to group cancel by user");
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle2.getString("shareGroupId");
    this.b = paramBundle2.getString("shareGroupName");
    this.jdField_a_of_type_Int = paramBundle2.getInt("add_video_source");
    ved.a("AddVideoMiddleCode", "shareGroupId = %s, shareGroupName = %s, source=%d", this.jdField_a_of_type_JavaLangString, this.b, Integer.valueOf(this.jdField_a_of_type_Int));
    StoryPickerFragment.a(a(), null, this.b, 1000, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukh
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.json.JSONArray;

public class qoz
  extends qwe
{
  private String axW;
  private String shareGroupId;
  private int source;
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.shareGroupId = paramBundle2.getString("shareGroupId");
    this.axW = paramBundle2.getString("shareGroupName");
    this.source = paramBundle2.getInt("add_video_source");
    ram.a("AddVideoMiddleCode", "shareGroupId = %s, shareGroupName = %s, source=%d", this.shareGroupId, this.axW, Integer.valueOf(this.source));
    StoryPickerFragment.a(o(), null, this.axW, 1000, 2);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      ram.w("AddVideoMiddleCode", "unknown request code %d", new Object[] { Integer.valueOf(paramInt1) });
      setResult(paramInt2, paramIntent);
      finish();
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
          ram.w("AddVideoMiddleCode", "let's add video to group, count = %d, collection = %s", new Object[] { Integer.valueOf(localLinkedHashSet.size()), new JSONArray(localLinkedHashSet).toString() });
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(localLinkedHashSet);
          pnx.a(this.shareGroupId, localArrayList, this.source);
          paramIntent.putExtra("totalPublishVideoCount", localLinkedHashSet.size());
          paramIntent.putExtra("isAddFromExist", true);
          setResult(paramInt2, paramIntent);
          finish();
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        ram.e("AddVideoMiddleCode", "StoryPickerFragment return illegal value", localClassCastException);
        Object localObject = null;
        continue;
        ram.w("AddVideoMiddleCode", "do not add video to group, exit ! result=%s, retValue=%s", new Object[] { Integer.valueOf(paramInt2), localObject });
        paramInt2 = 0;
        continue;
      }
      ram.w("AddVideoMiddleCode", "add video to group cancel by user");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoz
 * JD-Core Version:    0.7.0.1
 */
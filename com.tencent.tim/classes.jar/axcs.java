import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

class axcs
  implements axzv<List<axby>>
{
  axcs(axco paramaxco) {}
  
  public void ah(@Nullable List<axby> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      axco.a(this.a).clear();
      axco.a(this.a).addAll(paramList);
      axco.a(this.a).notifyDataSetChanged();
      paramList = axco.a(this.a).getActivity().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      axiy.i("AEGIFStickerListPart", "takeSameId=" + paramList);
      if (!TextUtils.isEmpty(paramList))
      {
        int i = 0;
        while (i < axco.a(this.a).size())
        {
          axby localaxby = (axby)axco.a(this.a).get(i);
          if ((localaxby != null) && (paramList.equals(localaxby.id)))
          {
            axco.a(this.a, localaxby);
            axco.a(this.a).adJ(i + 1);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcs
 * JD-Core Version:    0.7.0.1
 */
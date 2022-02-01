import android.view.View;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.List;

class rdx
  implements pub.c
{
  rdx(rdv paramrdv, String paramString) {}
  
  public void a(int paramInt, pub.d paramd, List<TroopBarPOI> paramList)
  {
    this.this$0.b = paramd;
    if (!this.this$0.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramd.Cz()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.this$0.oM.setVisibility(0);
      this.this$0.tG(bool);
      if (this.this$0.nw == null) {
        this.this$0.nw = new ArrayList();
      }
      if (this.this$0.b.IZ()) {
        this.this$0.nw.clear();
      }
      this.this$0.nw.addAll(paramList);
      if (this.this$0.a != null)
      {
        this.this$0.a.a(this.this$0.nw, null);
        this.this$0.a.notifyDataSetChanged();
        if (this.this$0.nw.isEmpty())
        {
          this.this$0.su(this.val$keyword);
          this.this$0.oM.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      rar.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdx
 * JD-Core Version:    0.7.0.1
 */
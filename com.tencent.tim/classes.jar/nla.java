import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class nla
  extends aeaz.b
{
  public nla(FastWebActivity paramFastWebActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    nns.a(FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0), this.this$0.getApplicationContext());
    if (paramBundle.getInt("color_note_curd_from_type") != 1) {
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nla
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

class ytd
  implements Runnable
{
  ytd(ytc paramytc) {}
  
  public void run()
  {
    if (ApolloGameActivity.a(this.a.a) != null)
    {
      ApolloGameActivity.a(this.a.a).a = true;
      ApolloGameActivity.a(this.a.a).a(this.a.a.getWindow().getDecorView());
      this.a.a.getWindow().addFlags(2048);
      this.a.a.getWindow().clearFlags(1024);
      this.a.a.getWindow().clearFlags(67108864);
      this.a.a.getWindow().clearFlags(134217728);
      this.a.a.getWindow().setFlags(256, 65536);
      this.a.a.getWindow().clearFlags(256);
      this.a.a.getWindow().clearFlags(512);
      this.a.a.getWindow().addFlags(256);
      this.a.a.findViewById(2131362828).setVisibility(8);
      this.a.a.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytd
 * JD-Core Version:    0.7.0.1
 */
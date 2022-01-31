import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class yzp
  implements Runnable
{
  public yzp(ApolloGameActivity paramApolloGameActivity) {}
  
  public void run()
  {
    if (ApolloGameActivity.a(this.a) != null)
    {
      ApolloGameActivity.a(this.a).a = true;
      ApolloGameActivity.a(this.a).a(this.a.getWindow().getDecorView());
      this.a.getWindow().addFlags(2048);
      this.a.getWindow().clearFlags(1024);
      this.a.getWindow().clearFlags(67108864);
      this.a.getWindow().clearFlags(134217728);
      this.a.getWindow().setFlags(256, 65536);
      this.a.getWindow().clearFlags(256);
      this.a.getWindow().clearFlags(512);
      this.a.getWindow().addFlags(256);
      this.a.findViewById(2131362833).setVisibility(8);
      this.a.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzp
 * JD-Core Version:    0.7.0.1
 */
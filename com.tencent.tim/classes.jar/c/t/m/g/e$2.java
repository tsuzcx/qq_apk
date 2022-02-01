package c.t.m.g;

import java.io.File;

final class e$2
  implements aj.b
{
  e$2(e parame, File paramFile) {}
  
  public final void a(String paramString)
  {
    if (ai.a()) {
      ai.a(3, "UserTrackPro", "upload succeed:".concat(String.valueOf(paramString)), null);
    }
    this.a.delete();
  }
  
  public final void b(String paramString)
  {
    if (ai.a()) {
      ai.a("UserTrackPro", "upload failed:".concat(String.valueOf(paramString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.e.2
 * JD-Core Version:    0.7.0.1
 */
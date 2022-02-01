class uho
  implements uoh
{
  uho(uhk paramuhk) {}
  
  public void a(String paramString)
  {
    uhk.a(this.a, true);
    upe.b("WSFollowFeedHolder", "[onUserClick] uid: " + paramString);
    String str = "weishi://profile?person_id=" + paramString;
    uov.a(uhk.a(this.a).a(), str, 700, uhk.a(this.a), "content");
    uhk.a(this.a, paramString);
  }
  
  public void b(String paramString)
  {
    uhk.a(this.a, true);
    upe.b("WSFollowFeedHolder", "[onTopicClick] tid: " + paramString);
    String str = "weishi://topic?topic_id=" + paramString;
    uov.a(uhk.a(this.a).a(), str, 700, uhk.a(this.a), "content");
    uhk.b(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uho
 * JD-Core Version:    0.7.0.1
 */
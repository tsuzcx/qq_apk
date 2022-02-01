class vcy
  implements vlq
{
  vcy(vcu paramvcu) {}
  
  public void a(String paramString)
  {
    if (vnd.b()) {
      return;
    }
    vcu.a(this.a, true);
    vmp.b("WSFollowFeedHolder", "[onUserClick] uid: " + paramString);
    String str = "weishi://profile?person_id=" + paramString;
    vmg.a(vcu.a(this.a).a(), str, 700, vcu.a(this.a), "content");
    vcu.a(this.a, paramString);
  }
  
  public void b(String paramString)
  {
    if (vnd.b()) {
      return;
    }
    vcu.a(this.a, true);
    vmp.b("WSFollowFeedHolder", "[onTopicClick] tid: " + paramString);
    String str = "weishi://topic?topic_id=" + paramString;
    vmg.a(vcu.a(this.a).a(), str, 700, vcu.a(this.a), "content");
    vcu.b(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcy
 * JD-Core Version:    0.7.0.1
 */
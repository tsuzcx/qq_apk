package moai.core.watcher;

import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

 enum Watchers$Subjects$2
{
  Watchers$Subjects$2()
  {
    super(str, i, null);
  }
  
  Subject<Watchers.Context, Watchers.Context> create()
  {
    return BehaviorSubject.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.Subjects.2
 * JD-Core Version:    0.7.0.1
 */
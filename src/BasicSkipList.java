import java.util.Random;


public class BasicSkipList {

	private SkipListEntry head;
	private int height;
	
	/*
	 * make all nodes level 1
		j ← 1
		while the number of nodes at level j > 1 do
		  for each i'th node at level j do
		    if i is odd 
		      if i is not the last node at level j
		        randomly choose whether to promote it to level j+1
		      else
		        do not promote
		      end if
		    else if i is even and node i-1 was not promoted
		      promote it to level j+1
		    end if
		  repeat
		  j ← j + 1
		repeat
	 */
	public BasicSkipList(){
		height = 1;
		head = new SkipListEntry(Integer.MIN_VALUE);
		head.setDown(new SkipListEntry(null));
		head.setRight(new SkipListEntry(Integer.MAX_VALUE));
	}
	
	public void add(Integer addValue){
		if(!head.getRight().getValue().equals(Integer.MAX_VALUE)){
			SkipListEntry newHead = new SkipListEntry(Integer.MIN_VALUE);
			newHead.setDown(head);
			newHead.setRight(new SkipListEntry(Integer.MAX_VALUE));
			SkipListEntry tempEnd = head.getRight();
			while (tempEnd.getValue() != Integer.MAX_VALUE){
				tempEnd = tempEnd.getRight();
			}
			newHead.getRight().setDown(tempEnd);
			height ++;
			head = newHead;
		}
		
		int myLevel = 0;
		Random random = new Random();
		while(random.nextBoolean() && myLevel <= height){
			myLevel++;
		}
		SkipListEntry currentEntry = head;
		SkipListEntry myRecentEntry = null;
		for(int i = 0; i< height-myLevel; i++){
			currentEntry = currentEntry.getDown();
		}

		while(currentEntry != null){
			while(currentEntry.getRight().getValue() < addValue){
				currentEntry = currentEntry.getRight();
			}
			if(currentEntry.getRight().getValue() > addValue){
				SkipListEntry toBeAdded = new SkipListEntry(addValue);
				SkipListEntry temp = currentEntry.getRight();
				currentEntry.setRight(toBeAdded);
				toBeAdded.setRight(temp);
				if(myRecentEntry != null){
					myRecentEntry.setDown(toBeAdded);
				}
				myRecentEntry = toBeAdded;
				currentEntry = currentEntry.getDown();
			}
		}
	}
	
	public SkipListEntry get(int val) {
		SkipListEntry cur = head;
		while (cur.getValue() != val || cur.getValue() == )
	}
	
	public boolean delete(int val) {
		
	}
}

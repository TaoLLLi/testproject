package suanfaTest;

public class RedTree {
	Node[] TreeList=new Node[100];
	int i=1;
	public void Insert(Node v){
		if(TreeList==null){
			TreeList[1]=v;
			i++;
		}
		else{
			SearchTree(TreeList[1],v);
		}
	}
	
	public void Delect(Node v){
		for(int j=1;j<=i;j++){
			if(TreeList[j]!=null){
		if(((TreeList[j].vertex1==v.vertex1)||(TreeList[j].vertex1==v.vertex2))&&
				((TreeList[j].vertex2==v.vertex1)||(TreeList[j].vertex2==v.vertex2))){
			if(TreeList[j].parent!=null){
				if(TreeList[j].parent.leftson==TreeList[j]){				
					if(TreeList[j].rightson!=null){
						TreeList[j].parent.leftson=TreeList[j].rightson;	
						//左二子怎么处理
					}
					else if(TreeList[j].leftson!=null){
						TreeList[j].parent.leftson=TreeList[j].leftson;
						//右儿子怎么处理
					}
				}
				else
				{
					if(TreeList[j].rightson!=null){
						TreeList[j].parent.rightson=TreeList[j].rightson;	
						//左二子怎么处理
					}
					else if(TreeList[j].leftson!=null){
						TreeList[j].parent.rightson=TreeList[j].leftson;
						//右儿子怎么处理
					}
				}
			}						
			TreeList[j]=null;
			//重排序,需要链表形式的数据结构，方便添加，删除
			
		}
			}
		}
	}
	
	public void SearchTree(Node treehead,Node v){	
			if(Computational_geometry.Cross_product(v.vertex1, treehead.vertex1)>0){
				if(treehead.leftson==null){
					treehead.leftson=v;
					v.parent=treehead;
					TreeList[i]=v;
					i++;
				}
				else
				{SearchTree(treehead.leftson,v);}
			}
			else{
				if(treehead.rightson==null){
					treehead.rightson=v;
					v.parent=treehead;
					TreeList[i]=v;
					i++;
				}
				else
				{SearchTree(treehead.rightson,v);}
			}
	}
	
	public void ListTree(){
		
	}
	
}


class Node{
	String color;
	Vertex vertex1=new Vertex();//起始点
	Vertex vertex2=new Vertex();//结束点
    Node leftson;
    Node rightson;
    Node parent;
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BellMan_FordAlgorithm
{
    public static class EdgeDetail
    {
        int from,to;double weight;

        public EdgeDetail(int from, int to, double weight)
        {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public double[] shortestPath(List<EdgeDetail> edgeSet,int src,int nodes)
    {
        double[] distance=new double[nodes];
        Arrays.fill(distance,Double.POSITIVE_INFINITY);distance[src]=0.0;
        for(int i=0;i<nodes;i++)
            for(EdgeDetail e : edgeSet)
                if(distance[e.from]+e.weight<distance[e.to])
                    distance[e.to]=distance[e.from]+e.weight;
        for(EdgeDetail e : edgeSet)
            if(distance[e.from]+e.weight<distance[e.to])
                distance[e.to]=Double.NEGATIVE_INFINITY;
        return distance;
    }

    public static void main(String[] args) {
        List<EdgeDetail> nodes=new ArrayList<>();
        nodes.add(new EdgeDetail(0,1,5.0));
        nodes.add(new EdgeDetail(1,6,60.0));
        nodes.add(new EdgeDetail(1,5,30.0));
        nodes.add(new EdgeDetail(1,2,20.0));
        nodes.add(new EdgeDetail(2,3,10.0));
        nodes.add(new EdgeDetail(2,4,75.0));
        nodes.add(new EdgeDetail(3,2,-15.0));
        nodes.add(new EdgeDetail(4,9,100.0));
        nodes.add(new EdgeDetail(5,6,5.0));
        nodes.add(new EdgeDetail(5,8,50.0));
        nodes.add(new EdgeDetail(5,4,25.0));
        nodes.add(new EdgeDetail(6,7,-50.0));
        nodes.add(new EdgeDetail(7,8,-10.0));
        nodes.add(new EdgeDetail(1,2,20.0));
        nodes.add(new EdgeDetail(2,3,10.0));
        BellMan_FordAlgorithm obj=new BellMan_FordAlgorithm();
        double[] dist=obj.shortestPath(nodes,0,10);
        for(double a : dist)
            System.out.print(a+" , ");
    }
}

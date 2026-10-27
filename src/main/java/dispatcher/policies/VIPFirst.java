package dispatcher.policies;

import trip.Trip;

import java.util.List;

/**
 * The VIP First policy.
 * The trip with the lowest priority number goes first, since it is the most important.
 * Trips with the same priority number go in the order they joined the ready line.
 */
public class VIPFirst implements Policy {

    @Override
    public Trip pickNext(List<Trip> readyLine) {
        if (readyLine.isEmpty()){
            return null;
        }

        Trip vip = readyLine.get(0);

        for (Trip trip : readyLine){
            if (trip.getPriority() < vip.getPriority()){
                vip = trip;
            }
        }
        return vip;
    }
}

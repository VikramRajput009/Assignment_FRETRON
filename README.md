# Assignment_FRETRON
It contains three Coding Assignment Solutions.

DISCRIPTION OF CODE-
Problem 1 : No accident please
1) Coordinate Class: Created to store x and y coordinates of a point.
@) FlightPath Class: Manages a list of coordinates representing a flight path, with methods to add coordinates and retrieve the path.
3) Intersection Check: Implemented the doIntersect method to check if two line segments intersect, using orientation and on-segment checks.
4) Orientation Method: Used to determine the relative orientation of three points.
5) Segment Check: Implemented onSegment method to check if a point lies on a line segment.
6) Validation of Flight Paths: Implemented isValidFlightPath method to check if any two flight paths intersect.

DISCRIPTION OF CODE-
Problem 2 : My Money My Shares
1) Input Handling: Used a Scanner to take the weights of apples as input from the user.
2) Stopping Condition: Allowed the user to stop input by entering -1.
3) Sorting: Sorted the apple weights in descending order using Collections.sort.
4) Target Weights Calculation: Calculated target weights for Ram (50%), Sham (30%), and Rahim (20%) based on the total weight of all apples.
5) Distribution Logic: Allocated apples to Ram, Sham, and Rahim while ensuring that each person's total weight does not exceed their target.
6) Additional Allocation: Handled any remaining apples to adjust for any discrepancies in distribution.

DISCRIPTION OF CODE-
Problem 3 : Kill All And Return Home
1) Input Handling: The program first takes input from the user for the number of soldiers and their coordinates. It stores these coordinates in a HashMap.
2) Castle Coordinates: The program then takes input for the starting coordinates of the specialized castle.
3) Finding Unique Paths: It calls the findUniquePaths method to find all unique paths from the starting coordinates to the positions of the soldiers, eliminating them in the process.
4) Recursive Path Finding: The findPaths method is a recursive function that navigates through the grid, checking each possible move (killing a soldier or jumping to the next cell) and recording the path taken.

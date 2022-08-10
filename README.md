# Calculate the smallest k-th element (including the median) of an unsorted array #

Consider an unsorted array of numbers.
The question is: How to calculate the median of the numbers?

The first approach would be to order the array.
After that, the return of the median becomes a trivial problem.

However, this approach has a time complexity of O(n log(n))
on average performance; and O(n²) on worst-case performance.

A better alternative, developed in this project, is to use the
Quickselect algorithm with the Median-of-Medians (when selecting the pivot).

With this approach, it is possible to achieve linear performance, even in the worst case.

`"Quickselect is linear-time on average, but it can require quadratic
time with poor pivot choices. If one instead consistently chooses "good"
pivots, this is avoided and one always gets linear performance even in the worst case."`

The Quickselect algorithm solves the following problem:

`"Given an array and a number k where k is smaller than the size of the array,
we need to find the k-th smallest element in the given array."`

Since the problem of finding the median is a sub-problem of the k-th smallest element,
we can use the Quickselect algorithm to solve the finding median problem.

## Project files ## 

You can find inside the project two classes:

- FindKElement: Quickselect implementation (returns the k-th smallest element of an unsorted array).
- Median: Extends the FindKElement, returning only the median.

You will also find unitary tests for both classes.

## Calculating the median of numbers in a distributed system ##

To calculate the median of numbers in a distributed system, we could use a similar approach.
Suppose you have a master node (or are able to use a consensus protocol to elect a master from among the servers).

The master first queries the servers for the size of their sets of data. With this information, the master knows the
size of each data set (as well as the total).

Each server will execute the Median-of-Medians algorithm and send the result to the master. After this, the master will
have one median for each server, and it can run (again) the Median-of-Medians locally. By doing this, the master will
generate a "good" pivot.

The master broadcasts this pivot to each server, and each server partitions its elements into those larger than or equal
to the broadcasted pivot and those smaller than the broadcasted pivot.

Each server returns to the master the size of the larger-than partition, call this m. If the sum of these sizes is
greater than k (the index of median), the master indicates to each server to disregard the less-than set for the
remainder of the algorithm. If it is less than k, then the master indicates to disregard the larger-than sets and
updates k = k - m. If it is exactly k, the algorithm terminates and the value returned is the pivot selected at the
beginning of the iteration.

If the algorithm does not terminate, recurse beginning with selecting a new random pivot from the remaining elements.

## Acknowledgments ##

Thank you very much for your time in evaluating my project. Feel free to contact me and share your thoughts!

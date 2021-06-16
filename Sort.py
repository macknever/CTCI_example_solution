class Sort:
    def mergeSort(self, nums):
        if len(nums) <= 1:
            return nums

        mid = len(nums) >> 1
        left = nums[:mid]
        right = nums[mid:]

        left = self.mergeSort(left)
        right = self.mergeSort(right)

        l = 0
        r = 0
        result = []
        while l < mid and r < len(nums) - mid:
            if left[l] < right[r]:
                result.append(left[l])
                l += 1
            else:
                result.append(right[r])
                r += 1

        if l == mid:
            while r < len(nums) - mid:
                result.append(right[r])
                r += 1

        else:
            while l < mid:
                result.append(left[l])
                l += 1

        return result

    def quickSort(self, nums):
        l = len(nums)
        self.quickSortHelper(nums,0,l-1)

    def quickSortHelper(self,nums,left, right):

        if left >= right:
            return
        pivot = nums[left]
        start = left
        end = right
       
        while start < end:
            while start < end and nums[end] > pivot:
                end -= 1
            if start < end:
                nums[start] = nums[end]
                start += 1
            while start < end and nums[start] < pivot:
                start += 1
            if start < end:
                nums[end] = nums[start]
                end -= 1
        nums[start] = pivot
        
        self.quickSortHelper(nums,left,start - 1)
        self.quickSortHelper(nums,start + 1, right)
    





if __name__ == "__main__":

    sort = Sort()
    nums = [3, 2, 1, 9, 8, 7, 6, 5, 4, 4, 4, 4]
    print(sort.mergeSort(nums))
    sort.quickSort(nums)
    print(nums)

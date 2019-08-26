class PeculiarBalance:

    """
    Can we save them? Beta Rabbit is trying to break into a lab that contains the only known zombie cure - but there's
    an obstacle. The door will only open if a challenge is solved correctly. The future of the zombified rabbit
    population is at stake, so Beta reads the challenge: There is a scale with an object on the left-hand side, whose
    mass is given in some number of units. Predictably, the task is to balance the two sides. But there is a catch:
    You only have this peculiar weight set, having masses 1, 3, 9, 27, ... units. That is, one for each power of 3.
    Being a brilliant mathematician, Beta Rabbit quickly discovers that any number of units of mass can be balanced
    exactly using this set.

    To help Beta get into the room, write a method called answer(x), which outputs a list of strings representing where
    the weights should be placed, in order for the two sides to be balanced, assuming that weight on the left has mass
    x units.

    The first element of the output list should correspond to the 1-unit weight, the second element to the 3-unit
    weight, and so on. Each string is one of:

    "L" : put weight on left-hand side
    "R" : put weight on right-hand side
    "-" : do not use weight
    To ensure that the output is the smallest possible, the last element of the list must not be "-".

    x will always be a positive integer, no larger than 1000000000.

    """

    @staticmethod
    def answer(x):
        """
        Peculiar Balance.


        Parameters
        ----------
        x : int


        Returns
        -------
        ret : list


        Examples
        --------
        >>> PeculiarBalance().answer(2)
        ['L', 'R']

        >>> PeculiarBalance().answer(8)
        ['L', '-', 'R']

        >>> PeculiarBalance().answer(345)
        ['-', 'R', 'L', 'R', 'R', 'R']

        """

        def _to_rev_ternary(q):
            """
            Converts `q` to ternary equivalent in reversed order.


            Parameters
            ----------
            q : int

            Returns
            -------
            d2t : list


            Examples
            --------
            >>> _to_rev_ternary(345)
            [0, 1, 2, 0, 1, 1]

            """

            d2t = []
            if q == 0:
                d2t.append(0)
            while q > 0:
                d2t.append(q % 3)
                q = q // 3
            return d2t

        def _to_rev_balanced_ternary(s_q):
            """
            Converts `s_q` into balanced ternary.


            Parameters
            ----------
            s_q : list


            Returns
            -------
            t2bt : list


            Examples
            --------
            >>> _to_rev_balanced_ternary([0, 1, 2, 0, 1, 1])
            [0, 1, 'T', 1, 1, 1]

            """

            t2bt = []
            carry = 0
            for trit in s_q:
                if (trit == 2) or (trit + carry == 2):
                    trit = trit + carry + 1
                if trit == 3:
                    t2bt.append('T')
                    carry = 1
                elif trit == 4:
                    t2bt.append(0)
                    carry = 1
                else:
                    t2bt.append(trit + carry)
                    carry = 0
            if carry > 0:
                t2bt.append(carry)
            return t2bt

        # Unbalanced ternary
        _t = _to_rev_ternary(x)
        # print("""Ternary: {}""".format(_t[::-1]))

        # Balanced ternary
        _bt = _to_rev_balanced_ternary(_t)
        # print("""Balanced Ternary: {}""".format(_bt[::-1]))
        return [('L' if (str(t)) == 'T' else ('R' if t == 1 else '-')) for t in _bt]
